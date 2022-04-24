package com.project.fdb.Recruitment.Portal.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.service.CandidateService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/RP")
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
	

	@PostMapping("/addCandidateDetails")
	public AppResponse addCandidateDetails(@RequestBody CandidateDetails candidateDetails) {
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
}
