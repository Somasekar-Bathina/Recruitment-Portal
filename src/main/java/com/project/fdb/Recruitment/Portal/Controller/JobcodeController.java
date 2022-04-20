package com.project.fdb.Recruitment.Portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.JobCodeDetails;
import com.project.fdb.Recruitment.Portal.repository.JobcodeDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RP")
@Slf4j
public class JobcodeController {

	@Autowired
	private JobcodeDetailsRepository jobCodeDetailsRepo;
	
	@GetMapping("jobcode/availableJobCodes")
	public void getAvailableJobcodeDetails() {
		List<JobCodeDetails> jobcodeDetails = null;
		try {
			
		}catch(Exception e) {
			log.info("Exception occcured while fetching jobcode details{}",e.getMessage());
		}
		
	}
	
	
}
