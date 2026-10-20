package com.lm.service;

import java.util.List;

import com.lm.entity.Employee;
import com.lm.entity.LeaveRequest;
import com.lm.vo.EmployeeVO;
import com.lm.vo.LeaveRequestVO;

import jakarta.servlet.http.HttpSession;

public interface ILeaveMgmtService 
{
	public String addEmployee(EmployeeVO em);
	public Boolean employeeLogin(String mail,String pwd,HttpSession session);
	public String applyLeavereq(LeaveRequestVO lrq);
	public List<LeaveRequest> showAllLeavesByEmpIdAndStatus(Integer id);
	public List<LeaveRequest> showAllPendingLeaves(Integer id);
	public String deleterLeaveReq(Integer id);
	public Boolean managerLogin(String mail,String pwd,HttpSession session);
	public List<LeaveRequest> showAllRequestedLeaves();
	public LeaveRequest findByLeaveId(Integer id);
	public Employee findEmployeeById(Integer id);
	public String editLeaveRequest(LeaveRequestVO vo,String status) throws Exception;
	public List<Employee> viewAllEmployess();
}
