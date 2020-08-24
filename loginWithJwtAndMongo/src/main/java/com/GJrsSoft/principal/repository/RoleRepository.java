package com.GJrsSoft.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GJrsSoft.principal.models.ERole;
import com.GJrsSoft.principal.models.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

	Optional<Role> findByName(ERole name);
	
}
