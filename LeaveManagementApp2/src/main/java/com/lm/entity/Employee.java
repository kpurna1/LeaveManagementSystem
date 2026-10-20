package com.lm.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_sq1",allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	private String email;
	@NonNull
	@Column(length = 20)
	private String password;
	@NonNull
	@Column(length = 20)
	private String role;
	private Integer leaveBalance=5;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate joinedOn;
	
}
