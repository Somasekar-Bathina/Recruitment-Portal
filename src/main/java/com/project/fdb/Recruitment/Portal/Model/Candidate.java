package com.project.fdb.Recruitment.Portal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

	private CandidateDetails candidateDetails;
	
	private CandidateWorkExperience workExperience;
	
	private CandidateQualification candQualifications;

}
