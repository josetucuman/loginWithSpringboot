package com.GJrsSoft.principal.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import lombok.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "users", 
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@NotBlank
	@Size(max = 20)
	private String username;
	
	@NotBlank @Size(max = 50)
	private String email;
	
	@NotBlank @Size(max = 150)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name ="user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) String email,
			@NotBlank @Size(max = 150) String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	

}
