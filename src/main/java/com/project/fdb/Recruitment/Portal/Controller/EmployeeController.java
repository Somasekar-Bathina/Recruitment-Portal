package com.project.fdb.Recruitment.Portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.repository.CandidateApplicationRepository;
import com.project.fdb.Recruitment.Portal.repository.EmployeeRepository;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/RP/Employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private CandidateApplicationRepository candRepo;
	
	
	@GetMapping("/getAllCandidateApplications")
	public AppResponse getAllCandidateApplications() {
		
		AppResponse response = AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		List<CandidateApplication> candApplList = null;
		try {
			candApplList= candRepo.findAll();
			response.setResponseMessage("CandidateApplciations fetched successfully");
			response.setResponseObject(candApplList);
		}catch(Exception e) {
			log.info("Exception occured while fetching {}",e.getMessage());
		}
		
		
		return response;
	}

}
