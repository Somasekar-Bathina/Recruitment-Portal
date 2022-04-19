package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "available_jobs")
@AllArgsConstructor
@NoArgsConstructor
public class AvailableJobs {

	@Id
	@GeneratedValue()
	private Integer job_id;
	
	@Column
	private String job_title;
	
	@Column(name = "employment_type")
	private char employeeType;
	
	@Column(name ="job_description")
	private String job_description;
	
	@Column(name = "effective_date")
	private Date effective_date;
	
	@Column(name = "jobcode_id")
	private Integer jobcode_id;
}
