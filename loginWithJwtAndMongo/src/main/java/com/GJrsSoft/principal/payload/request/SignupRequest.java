package com.GJrsSoft.principal.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class SignupRequest {
	
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String username;
	
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	@NotBlank
	@Size(max = 50)
	private String email;
	
	private Set<String> roles;
	
}
