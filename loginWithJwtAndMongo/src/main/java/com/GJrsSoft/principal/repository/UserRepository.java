package com.GJrsSoft.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GJrsSoft.principal.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findByUsername(String user);
	
	Boolean existsByUsername(String user);
	
	Boolean existsByEmail(String mail);

	

}
