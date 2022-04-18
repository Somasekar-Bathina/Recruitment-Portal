package com.project.fdb.Recruitment.Portal.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CandidateRegister {

	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String password;
}
