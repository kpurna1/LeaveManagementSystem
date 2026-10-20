package com.lm.controler;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lm.entity.Employee;
import com.lm.entity.LeaveRequest;
import com.lm.service.ILeaveMgmtService;
import com.lm.vo.EmployeeVO;
import com.lm.vo.LeaveRequestVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LeaveManagementController 
{

	@Autowired
	private ILeaveMgmtService service;

	@GetMapping("/")
	public String home()
	{
		return"index";
	}
	@GetMapping("/Emplogin")
	public String loginPage()
	{
		return "login";
	}
	@PostMapping("/login1")
	public String empLogin(@RequestParam String emailId,@RequestParam String password,RedirectAttributes att,HttpSession session)
	{
		//System.out.println(emailId+" "+password);
		Boolean login=service.employeeLogin(emailId, password,session);
		if(login) {
			
			return "emphome";
		}
		else {
			att.addFlashAttribute("response", "Invalid Creadientials");
			return "redirect:Emplogin";
		}
	}
	
	@GetMapping("/login2")
	public String showHomePage()
	{
		return "emphome";
	}
	
	@GetMapping("/empRegister")
	public String registrationPage(@ModelAttribute("emp") EmployeeVO em)
	{
		return "Registration";
	}
	@PostMapping("/empReg")
	public String register(RedirectAttributes att, @ModelAttribute("emp") EmployeeVO em)
	{
		String msg=service.addEmployee(em);
		att.addFlashAttribute("msg", msg);
		return "redirect:Emplogin";
	}
	@GetMapping("/leave")
	public String showForm(@ModelAttribute("leave") LeaveRequestVO lq)
	{
		return "leavePage";
	}
	@PostMapping("/apply")
	public String applyLeave(RedirectAttributes att,@ModelAttribute("leave") LeaveRequestVO lvq)
	{
		
		System.out.println(lvq);
		String msg=service.applyLeavereq(lvq);
		att.addFlashAttribute("resp", msg);
		return "redirect:login2";
	}
	@GetMapping("/view")
	public String viewLeaves(Map<String,Object> map,HttpSession session)
	{
		List<LeaveRequest> list=service.showAllLeavesByEmpIdAndStatus((Integer)session.getAttribute("id"));
		map.put("leaveHistory", list);
		return "leaveHistory";
	}
	@GetMapping("/viewStatus")
	public String viewPendingLeaves(Map<String,Object> map,HttpSession session)
	{
		List<LeaveRequest> list=service.showAllPendingLeaves((Integer)session.getAttribute("id"));
		map.put("leaveStatus", list);
		return"leaveStatus";
	}
	@PostMapping("/cancel")
	public String deleterLeave(RedirectAttributes att,@RequestParam Integer leaveId)
	{
		String msg=service.deleterLeaveReq(leaveId);
		att.addFlashAttribute("delMsg", msg);
		return "redirect:viewStatus";
	}
	@GetMapping("/logout")
	public String logOutEmpSession(HttpSession session)
	{
		session.removeAttribute("id");
		session.invalidate();
		return"forward:/";
	}
	@GetMapping("/Manlogin")
	public String loginPage1()
	{
		return "Managerlogin";
	}
	@PostMapping("/login2")
	public String managerLogin(@RequestParam String emailId,@RequestParam String password,RedirectAttributes att,HttpSession session)
	{
		Boolean login=service.managerLogin(emailId, password, session);
		if(login) {
			
			return "managerhome";
		}
		else {
			att.addFlashAttribute("response", "Invalid Creadientials");
			return "redirect:Manlogin";
		}
	}
	@GetMapping("/login3")
	public String managerHome()
	{
		return "managerhome";
	}
	@GetMapping("/ViewLeaves")
	public String showReqLeaves(Map<String,Object> map,@ModelAttribute("lev") LeaveRequestVO lev)
	{
		List<LeaveRequest> list=service.showAllRequestedLeaves();
		map.put("leaveRequests", list);
		return "leaveRequests";
	}
	
	@GetMapping("/resp")
	public String respond(@RequestParam Integer levno,@RequestParam Integer no,
												@ModelAttribute("lev") LeaveRequestVO lev,
												Map<String,Object> map)
	{
		LeaveRequest lq=service.findByLeaveId(levno);
		BeanUtils.copyProperties(lq, lev);
		Employee emp =service.findEmployeeById(no);
		map.put("name", emp.getName());
		map.put("role", emp.getRole());
		return"respond";
	}
	@PostMapping("/update")
	public String sendMailToEmp(RedirectAttributes att,
								@ModelAttribute("lev") LeaveRequestVO lev,
								@RequestParam String status)
	{
		String msg="Internal problem";
		try {
			msg = service.editLeaveRequest(lev, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		att.addFlashAttribute("msg", msg);
		return "redirect:ViewLeaves";
	}
	@GetMapping("/ViewEmps")
	public String viewAllEmps(Map<String,Object> map)
	{
		List<Employee> list =service.viewAllEmployess();
		map.put("allEmps", list);
		return"employess";
	}
}
