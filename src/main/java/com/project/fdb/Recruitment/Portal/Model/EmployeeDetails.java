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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "employee_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {

	@Id
	@Column(name= "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	@Column(name="fname")
	private String first_name;
	
	@Column(name="lname")
	private String last_name;
	
	@Column(name="jobcode_id")
	private String jobcode_id;
	
	@Column(name="employee_type")
	private String employee_type;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="martial_status")
	private String martialStatus;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name = "address_line1")
	private String address_line1;		
	
	@Column(name = "address_line2")
	private String address_line2;
	
	@Column(name="joining_table")
	private Date joiningDate;
	
	@Column(name="termination_date")
	private Date terminationDate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "zipcode", referencedColumnName = "zipcode")
	@JsonIgnore
	private ZipLocations  zipcode;
}
