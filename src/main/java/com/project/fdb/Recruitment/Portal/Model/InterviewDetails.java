package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="interview_schedule")
public class InterviewDetails {
	
	@Column(name ="candidate_id")
	private String candidate_id;
	
	@Column(name = "interview_date")
	private Date interview_date;
	
	@Column(name = "status_codee")
	private Integer status_code;
	
	@Column(name= "interview_by")
	private Integer interview_by;
	
	@Column(name ="last_updated_timestamp")
	private Timestamp last_updated_timestamp;
}
