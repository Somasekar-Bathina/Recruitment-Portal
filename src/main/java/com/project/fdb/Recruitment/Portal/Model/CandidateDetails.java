package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "candidate_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDetails {
	
	@Id
	@Column(name= "candidate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;

	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name = "address_line1")
	private String address_line1;		
	
	@Column(name = "address_line2")
	private String address_line2;
	
	@Column(name = "zipcode")
	private String  zipcode;
}
