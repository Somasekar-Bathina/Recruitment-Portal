package com.project.fdb.Recruitment.Portal.service.impl;

import java.time.Instant;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateRegister;
import com.project.fdb.Recruitment.Portal.Model.LoginDetails;
import com.project.fdb.Recruitment.Portal.Model.LoginResponse;
import com.project.fdb.Recruitment.Portal.repository.LoginRepository;
import com.project.fdb.Recruitment.Portal.service.LoginService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Setter
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepos;
	
	
	
	@Override
	public AppResponse userSignUp(CandidateRegister registerCandidate) {
		
		AppResponse response =  AppResponse.builder().build();
		LoginDetails loginDetails = LoginDetails.builder().build();
		if(checkUser(registerCandidate.getEmail())) {
			
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.USER_ALREADY_EXIST);
			return response;
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.USER_CREATED);
		loginDetails.setPassword(registerCandidate.getPassword());
		loginDetails.setUserType(RPConstants.CANDIDATE);
		loginRepos.save(loginDetails);
		
		return response;
	}

	private boolean checkUser(String email) {
		
		LoginDetails responseUser = loginRepos.findByEmail(email);
		if(Objects.isNull(responseUser))
			return false;
		return true;
		
	}

	@Override
	public AppResponse userSignin(LoginDetails loginDetails) {
		
		AppResponse response = AppResponse.builder().build();
		LoginResponse loginResponse = LoginResponse.builder().build();
		
		try {
		LoginDetails login =  loginRepos.findByUsernameAndPassword(loginDetails.getEmail(),loginDetails.getPassword());
		if(Objects.isNull(login)) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.INVALID_LOGIN_CREDENTIALS );
			log.info("Login Response :{}",response);
			return response;
		}
		loginResponse.setUserType(login.getUserType());
		loginResponse.setName(null);
		}catch(Exception e) {
			log.info("Exception occured while finding user account:{}",e.getMessage());
		}
		
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.LOGIN_SUCCESSFULL);
		response.setResponseObject(loginResponse);
		log.info("Login Response :{}",response);
		return response;
	}

	@Override
	public AppResponse forgotpassword(String email) {
		
		AppResponse response = AppResponse.builder().build();
		if(checkUser(email)) {
			response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
			response.setResponseMessage(RPConstants.DEFAULT_PASSWORD_MAIL);
			return response;
		}
		response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
		response.setResponseMessage(RPConstants.USER_ACCOUNT_NOT_FOUND);
		return response;
	}
	
	@Override
	public AppResponse updatePassword(String email,String password) {
		
		AppResponse response = AppResponse.builder().build();
		if(checkUser(email)) {
			response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
			response.setResponseMessage(RPConstants.DEFAULT_PASSWORD_MAIL);
			return response;
		}
		try {
			loginRepos.updatePassword(email, password);
		}catch(Exception e) {
			log.info("Exception occured while updating the password {}",e.getMessage());
		}
		response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
		response.setResponseMessage(RPConstants.USER_PASSWORD_UPDATED_SUCCESSFULLY);
		return response;
	}


}
