package com.project.fdb.Recruitment.Portal.Controller;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateRegister;
import com.project.fdb.Recruitment.Portal.Model.LoginDetails;
import com.project.fdb.Recruitment.Portal.service.LoginService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/RP")
@Slf4j
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/signup")
	public AppResponse signup(@RequestBody CandidateRegister candidateRegister ) {
		
		AppResponse response = AppResponse.builder().build();
		if(Objects.isNull(candidateRegister)
		   || StringUtils.isEmpty(candidateRegister.getEmail())
		   || StringUtils.isEmpty(candidateRegister.getFirst_name())
		   || StringUtils.isEmpty(candidateRegister.getPassword())) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.INVALID_CREDENTIALS);
			return response;
		}
		
		return loginService.userSignUp(candidateRegister);
		
	}
	
	@PostMapping("/login")
	public AppResponse signin(@RequestBody LoginDetails loginDetails) {
		
		AppResponse response = AppResponse.builder().build();
		log.info("User requested for Sign in:{}",loginDetails);
		if(Objects.isNull(loginDetails)
		   || StringUtils.isEmpty(loginDetails.getEmail())
		   || StringUtils.isEmpty(loginDetails.getPassword()))
		    {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.INVALID_CREDENTIALS);
			return response;
		}
		
		return loginService.userSignin(loginDetails);
		
	}
	
	@GetMapping("/forgotpassword")
	public AppResponse forgotpassword(@RequestHeader String email) {
		
		AppResponse response = AppResponse.builder().build();
		String sanitizeParam = HtmlUtils.htmlEscape(email);
		if(StringUtils.isEmpty(email))
		    {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.INVALID_EMAIL_ID);
			return response;
		}
		
		return loginService.forgotpassword(sanitizeParam);
		
	}
	
	@PutMapping("/updatePassword")
	public AppResponse updatePassword(@RequestHeader String email,String password) {
		
		AppResponse response = AppResponse.builder().build();
		String sanitizeParam = HtmlUtils.htmlEscape(email);
		String santizePass = HtmlUtils.htmlEscape(password);
		if(StringUtils.isEmpty(email))
		    {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage(RPConstants.INVALID_EMAIL_ID);
			return response;
		}
		
		return loginService.updatePassword(sanitizeParam,santizePass);
		
	}
}
