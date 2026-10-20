package com.lm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lm.entity.Manager;

public interface IManagerRepo extends JpaRepository<Manager, Integer> 
{
	Optional<Manager> findByEmailAndPassword(String email, String password);

}
