package com.lm.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeaveRequestVO 
{
	
	private Integer leave_id;
	private Integer employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	
}
