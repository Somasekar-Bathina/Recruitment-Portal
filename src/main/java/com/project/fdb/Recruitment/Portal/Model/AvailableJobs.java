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
@Builder
@Table(name = "available_jobs")
@AllArgsConstructor
@NoArgsConstructor
public class AvailableJobs {

	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer job_id;
	
	@Column(name = "job_title")
	private String job_title;
	
	@Column(name = "employment_type")
	private char employment_type;
	
	@Column(name ="job_description")
	private String job_description;
	
	@Column(name = "effective_date")
	private Date effective_date;
	
	@Column(name = "jobcode_id")
	private Integer jobcode_id;
	
	@Column(name = "status_code")
	private Integer status_code;
	
}
