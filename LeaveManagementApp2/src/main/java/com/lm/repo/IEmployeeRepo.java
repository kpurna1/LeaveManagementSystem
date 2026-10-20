package com.lm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lm.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> 
{
	Optional<Employee> findByEmailAndPassword(String email, String password);
}
