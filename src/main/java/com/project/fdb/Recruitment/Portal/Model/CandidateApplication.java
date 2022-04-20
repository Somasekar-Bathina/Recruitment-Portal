package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "candidate_application")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateApplication {
	
	@EmbeddedId
	private CandidateApplicationId candApplicationId;
	
	@Column(name= "job_status")
	private String job_status;
	
	@Column(name= "status_code")
	private Integer status_code;
	
	@Column(name= "applied_date")
	private Date applied_date;
	
	@Column(name= "last_updated_timestamp")
	private Timestamp last_updated_timestamp;
	
	
}
