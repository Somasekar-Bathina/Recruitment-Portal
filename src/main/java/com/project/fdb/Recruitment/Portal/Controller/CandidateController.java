package com.project.fdb.Recruitment.Portal.Controller;

import java.util.Objects;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateQualification;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;
import com.project.fdb.Recruitment.Portal.service.CandidateService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;


@RestController
@RequestMapping("/RP")
@CrossOrigin
public class CandidateController {

	@Autowired
	private CandidateService candService;

	@GetMapping("/getCandidateDetails")
	public AppResponse getCandidateDetails(@RequestHeader Integer candidateId) {
		
		AppResponse response = AppResponse.builder()
								.responseCode(RPConstants.BAD_REQUEST_4XX_CODE)
								.build();
		if(candidateId == null) {
			response.setResponseMessage(RPConstants.INVALID_CREDENTIALS);
			return response;
		}
		return candService.getCandidateDetails(candidateId);
	}
	

	@PostMapping("/saveCandidateDetails")
	public AppResponse saveCandidateDetails(@RequestBody CandidateDetails candidateDetails) {
		AppResponse response = AppResponse.builder()
				.responseCode(RPConstants.BAD_REQUEST_4XX_CODE)
				.build();
		if(Objects.isNull(candidateDetails)
				|| candidateDetails.getCandidateId() ==null
				) {
		response.setResponseMessage(RPConstants.INVALID_CREDENTIALS);
		return response;
		}
			
	    return candService.addCandidateDetails(candidateDetails);	
	}
	
	@PostMapping("/saveEducationalDetails")
	public AppResponse saveEducationalDetails(@RequestBody List<CandidateQualification> candidateQualDetails) {
		AppResponse response = AppResponse.builder()
				.responseCode(RPConstants.BAD_REQUEST_4XX_CODE)
				.build();
		if(candidateQualDetails.isEmpty()){
		response.setResponseMessage(RPConstants.INVALID_EDUCATIONDETAILS);
		return response;
		}
			
	    return candService.saveEducationalDetails(candidateQualDetails);	
	}
	
	@PostMapping("/saveWorkExpDetails")
	public AppResponse saveWorkExpDetails(@RequestBody List<CandidateWorkExperience> candidateWorkDetails) {
		AppResponse response = AppResponse.builder()
				.responseCode(RPConstants.BAD_REQUEST_4XX_CODE)
				.build();
		if(candidateWorkDetails.isEmpty()){
		response.setResponseMessage(RPConstants.INVALID_WORK_EXPERIENCE);
		return response;
		}
			
	    return candService.saveWorkExpDetails(candidateWorkDetails);	
	}
}
