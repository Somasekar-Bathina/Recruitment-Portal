package com.project.fdb.Recruitment.Portal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.service.AvailableJobsService;

@RestController
@RequestMapping("/RP")
public class JobsController {

	
	@Autowired
	private AvailableJobsService availableJobService;
	
	@GetMapping("/candidate/availableJobs")
	public AppResponse getCandidateAvailableJobs(@RequestHeader Integer candidateId) {
		
		return availableJobService.getCandidateAvailableJobs(candidateId);
	}
}
