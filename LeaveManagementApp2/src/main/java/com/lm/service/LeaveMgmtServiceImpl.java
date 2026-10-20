package com.lm.service;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lm.entity.Employee;
import com.lm.entity.LeaveRequest;
import com.lm.entity.Manager;
import com.lm.repo.IEmployeeRepo;
import com.lm.repo.ILeaveRequestRepo;
import com.lm.repo.IManagerRepo;
import com.lm.vo.EmployeeVO;
import com.lm.vo.LeaveRequestVO;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;


@Service
public class LeaveMgmtServiceImpl implements ILeaveMgmtService 
{
	@Autowired
	private IEmployeeRepo empRepo;
	@Autowired
	private ILeaveRequestRepo leaveRepo;
	@Autowired
	private IManagerRepo manRepo;
	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String senderMail;
    
	@Override
	public String addEmployee(EmployeeVO em)
	{
		Employee entity = new Employee();
		BeanUtils.copyProperties(em, entity);
		Integer id=empRepo.save(entity).getId();
		return "Registration successfull with id::"+id;
	}
	@Override
	public Boolean employeeLogin(String mail, String pwd,HttpSession session) 
	{
		Optional<Employee> opt=empRepo.findByEmailAndPassword(mail, pwd);
		if(opt.isPresent())
		{
			
			session.setAttribute("id", opt.get().getId());
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String applyLeavereq(LeaveRequestVO lrq) 
	{
		Optional<Employee> opt =empRepo.findById(lrq.getEmployeeId());
		if(opt.isPresent())
		{
			LeaveRequest entity= new LeaveRequest();
			BeanUtils.copyProperties(lrq, entity);
			Integer id=leaveRepo.save(entity).getLeave_id();
			return "Leave Applyed  Leave_id ::"+id;
		}else 
		{
			return lrq.getEmployeeId()+" id Employee is not found ";
		}
	}
	@Override
	public List<LeaveRequest> showAllLeavesByEmpIdAndStatus(Integer id) 
	{
		//List<LeaveRequest> list=leaveRepo.findByEmployeeId(id);
		List<LeaveRequest> list=leaveRepo.findByEmployeeIdAndStatusIn(id, Arrays.asList("ACCEPTED", "REJECTED"));
		return list;
	}
	@Override
	public List<LeaveRequest> showAllPendingLeaves(Integer id) 
	{
		List<LeaveRequest> list=leaveRepo.findByEmployeeIdAndStatus(id, "PENDING");
		return list;
	}
	@Override
	public String deleterLeaveReq(Integer id) 
	{
		leaveRepo.deleteById(id);
		return id+" id leave deleted ";
	}
	@Override
	public Boolean managerLogin(String mail, String pwd, HttpSession session) 
	{
		Optional<Manager> opt =manRepo.findByEmailAndPassword(mail, pwd);
		if(opt.isPresent())
		{
			session.setAttribute("id", opt.get().getId());
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<LeaveRequest> showAllRequestedLeaves() 
	{
		List<LeaveRequest> list =leaveRepo.findByStatus("PENDING");
		return list;
	}
	@Override
	public LeaveRequest findByLeaveId(Integer id) 
	{
		LeaveRequest lq =leaveRepo.findById(id).orElseThrow();
		return lq;
	}
	@Override
	public Employee findEmployeeById(Integer id) 
	{
		Employee emp =empRepo.findById(id).orElseThrow();
		return emp;
	}
	@Override
	public String editLeaveRequest(LeaveRequestVO vo, String status) throws Exception 
	{
		LeaveRequest lq =leaveRepo.findById(vo.getLeave_id()).orElseThrow();
		lq.setStatus(status);
		leaveRepo.save(lq);
	    Employee emp =empRepo.findById(vo.getEmployeeId()).orElseThrow();
	    if ("ACCEPTED".equalsIgnoreCase(status)) 
	    {
	    long days = Math.abs(ChronoUnit.DAYS.between(lq.getStartDate(), lq.getEndDate()));
	    Integer val = (int) (emp.getLeaveBalance()-days);
	    emp.setLeaveBalance(val);
	    empRepo.save(emp);
	    }
	    String msg="Your Leave Request has been "+status+".From :"+lq.getStartDate()+" To: "+lq.getEndDate()+".Given reason :"+lq.getReason();
	    String res = sendMail(msg,emp.getEmail());
		return "Leave Status Updated and "+res;
	}
	
	private String sendMail(String msg,String toMails) throws Exception
	{
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(senderMail);
		helper.setCc(toMails);
		helper.setSubject("Leave Request Status");
		helper.setSentDate(new Date());
		helper.setText(msg);
		sender.send(message);
		return "Mail Send";
	}
	
	@Override
	public List<Employee> viewAllEmployess() 
	{
		List<Employee> list =empRepo.findAll();
		return list;
	}
}
