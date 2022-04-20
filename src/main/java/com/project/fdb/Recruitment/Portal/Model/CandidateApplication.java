package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "candidate_application")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateApplication {
	
	@EmbeddedId
	private CandidateApplicationId candApplicationId;
	
	@Column(name= "job_status")
	private String jobStatus;
	
	@Column(name= "status_code")
	private Integer statusCode;
	
	@Column(name= "applied_date")
	private Date appliedDate;
	
	@Column(name= "last_updated_timestamp")
	private Timestamp lastUpdatedTimestamp;
	
	
}
