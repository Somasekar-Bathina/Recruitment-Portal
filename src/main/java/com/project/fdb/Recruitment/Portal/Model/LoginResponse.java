package com.project.fdb.Recruitment.Portal.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

	private String emailId;
	
	private String UserType;
	
	private String name;
	
	private CandidateDetails candidateDetails;
	
}
