package com.project.fdb.Recruitment.Portal.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateRegister;
import com.project.fdb.Recruitment.Portal.Model.LoginDetails;
import com.project.fdb.Recruitment.Portal.Model.LoginResponse;
import com.project.fdb.Recruitment.Portal.repository.CandidateDetailsRepository;
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
	
	@Autowired
	private CandidateDetailsRepository candRepo;
	
	
	
	@Override
	public AppResponse userSignUp(CandidateRegister registerCandidate) {
		
		AppResponse response =  AppResponse.builder().build();
		LoginDetails loginDetails = LoginDetails.builder().build();
		CandidateDetails candDetails = CandidateDetails.builder().build();
		if(checkUser(registerCandidate.getEmail())) {
			
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.USER_ALREADY_EXIST);
			return response;
		}
		String gender = registerCandidate.getGender();
		loginDetails.setEmail(registerCandidate.getEmail());
		loginDetails.setPassword(registerCandidate.getPassword());
		loginDetails.setUserType(RPConstants.CANDIDATE);
		candDetails.setEmail(registerCandidate.getEmail());
		if(gender.equalsIgnoreCase(RPConstants.MALE))
			candDetails.setGender(RPConstants.MALE);
		else if(gender.equalsIgnoreCase(RPConstants.FEMALE))
			candDetails.setGender(RPConstants.FEMALE);
		else 
			candDetails.setGender(RPConstants.OTHERS);
		candDetails.setFirst_name(registerCandidate.getFirst_name());
		candDetails.setLast_name(registerCandidate.getLast_name());
		try {
		loginRepos.save(loginDetails);
		CandidateDetails saveResponse= candRepo.save(candDetails);
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.USER_CREATED);
		}catch(Exception e ) {
			log.info("Exception occured while saving registered user into DB:{}",e.getMessage());
		}
		return response;
	}

	private boolean checkUser(String email) {
		try {
		LoginDetails responseUser = loginRepos.findByEmail(email);
		if(Objects.isNull(responseUser))
			return false;
		}catch(Exception e) {
			log.info("Exception occured while checking the userin DB{}",e.getMessage());
		}
		
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
		loginResponse.setEmailId(login.getEmail());
		loginResponse.setUserType(login.getUserType());
		if(login.getUserType().equalsIgnoreCase(RPConstants.CANDIDATE)) {
		CandidateDetails candDetails = candRepo.getCandidateDetails(loginDetails.getEmail());
		loginResponse.setCandidateDetails(candDetails);
		}else {
		}
		}catch(Exception e) {
			log.info("Exception occured while finding user account:{}",e.getStackTrace());
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
		if(!checkUser(email)) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.USER_PASSWORD_UPDATED_SUCCESSFULLY);
			
			return response;
		}
		try {
			loginRepos.updatePassword(email, password);
		}catch(Exception e) {
			log.info("Exception occured while updating the password {}",e.getMessage());
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.DEFAULT_PASSWORD_MAIL);
		return response;
	}


}
