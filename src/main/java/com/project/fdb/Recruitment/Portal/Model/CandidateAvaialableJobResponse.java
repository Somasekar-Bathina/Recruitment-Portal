package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Date;
import java.util.List;

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
	
	List<AvailableJobs> appliedJobs;
	
	List<AvailableJobs> openPositions;
	
	
	
}
