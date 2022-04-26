package com.project.fdb.Recruitment.Portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.InterviewDetails;
import com.project.fdb.Recruitment.Portal.repository.InterviewDetailsRepository;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RP")
@CrossOrigin
@Slf4j
public class InterviewController {
	
	@Autowired
	private InterviewDetailsRepository interviewRepo;
	
	@PostMapping("/getAllInterview")
	public AppResponse getAllInterviews() {
		
		AppResponse response = AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		List<InterviewDetails> candApplList = null;
		try {
			candApplList=interviewRepo.findAll();
			response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
			response.setResponseMessage("All Interview Scheduled are fetched successfully");
			response.setResponseObject(candApplList);
		}catch(Exception e) {
			log.info("Exception occured while fetching all interview details {}",e.getMessage());
			response.setResponseMessage("Exception Occured");
		}
		
		return response;
		
	}

	
}
