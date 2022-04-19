package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAvaialableJobResponse {

	private Integer candidateId;
	
	private Integer jobId;
	
	private String jobTitle;
	
	private String jobDescription;
	
	private Boolean isApplied;
	
	private String branchName;
	
	private String location;
	
	private Date effectiveDate;
	
	
}
