package com.project.fdb.Recruitment.Portal.Model;

import java.util.List;

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
	
	private ZipLocations zipCode;
	
	private List<CandidateWorkExperience> workExperience;
	
	private List<CandidateQualification> candQualifications;

}
