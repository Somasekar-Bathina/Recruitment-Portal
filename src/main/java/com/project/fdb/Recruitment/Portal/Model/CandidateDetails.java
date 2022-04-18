package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDetails {

	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
}
