package com.project.fdb.Recruitment.Portal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "login")
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoginDetails {

	@Id
	@Column(name = "email")
	private String 	email;
	
	@Column(name = "password")
	private String	password; 
	
	@Column(name ="user_type")
	private String userType;

	}
