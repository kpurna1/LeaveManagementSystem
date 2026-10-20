package com.lm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeVO 
{
	@NonNull
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private String password;
	
	private String role;
	
}
