package com.lm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lm.entity.LeaveRequest;
import java.util.List;


public interface ILeaveRequestRepo extends JpaRepository<LeaveRequest, Integer>
{
	public List<LeaveRequest> findByEmployeeId(Integer employeeId);
	public List<LeaveRequest> findByEmployeeIdAndStatusIn(Integer employeeId,List<String> statuses);
	public List<LeaveRequest> findByEmployeeIdAndStatus(Integer employeeId,String status);
	public List<LeaveRequest> findByStatus(String status);
}
