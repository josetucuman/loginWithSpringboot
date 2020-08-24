package com.GJrsSoft.principal.payload.response;

import java.util.List;
import java.util.Set;

import lombok.*;


@Data

public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private int _id;
	private String username;
	private String email;
	private List<String> roles;
	
	
	
	
	public JwtResponse(String token, int _id, String username, String email, List<String> roles2) {
		super();
		this.token = token;
		this._id = _id;
		this.username = username;
		this.email = email;
		this.roles = roles2;
	}
	
	
	
	}
