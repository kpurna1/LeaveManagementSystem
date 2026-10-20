package com.lm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class LeaveRequest 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "lev_seq1",allocationSize = 1,initialValue = 1234)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer leave_id;
	private Integer employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String status="PENDING";
	@CreationTimestamp
	private LocalDateTime apply_Data;
}
