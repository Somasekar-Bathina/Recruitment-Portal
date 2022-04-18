package com.project.fdb.Recruitment.Portal.service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateRegister;
import com.project.fdb.Recruitment.Portal.Model.LoginDetails;

public interface LoginService {
	
	public AppResponse userSignUp(CandidateRegister registerCandidate );

	public AppResponse userSignin(LoginDetails loginDetails);

	public AppResponse forgotpassword(String email);
	
	public AppResponse updatePassword(String email,String password);

}
