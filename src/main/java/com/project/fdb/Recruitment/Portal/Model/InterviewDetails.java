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
@Table(name="interview_schedule")
@AllArgsConstructor
@NoArgsConstructor
public class InterviewDetails {
	
	@EmbeddedId
	private CandidateApplicationId candAppId;
	
	@Column(name = "interview_date")
	private Date interview_date;
	
	@Column(name = "status_code")
	private Integer status_code;
	
	@Column(name= "interview_by")
	private Integer interview_by;
	
	@Column(name ="last_updated_timestamp")
	private Timestamp last_updated_timestamp;
}
