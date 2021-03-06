package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zipcode", referencedColumnName = "zipcode")
	@JsonBackReference
	private ZipLocations  zipcode;
	
	@Column(name = "step_id")
	private Integer step_id;


	
}
