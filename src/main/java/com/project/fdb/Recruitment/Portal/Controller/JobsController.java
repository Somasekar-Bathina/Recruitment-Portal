package com.project.fdb.Recruitment.Portal.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;
import com.project.fdb.Recruitment.Portal.repository.AvailableJobsRepository;
import com.project.fdb.Recruitment.Portal.service.AvailableJobsService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RP")
@Slf4j
public class JobsController {

	
	@Autowired
	private AvailableJobsService availableJobService;
	
	@Autowired
	private AvailableJobsRepository availableJobsRepo;
	
	@GetMapping("/candidate/availableJobs")
	public AppResponse getCandidateAvailableJobs(@RequestHeader Integer candidateId) {
		
		return availableJobService.getCandidateAvailableJobs(candidateId);
	}
	
	@GetMapping("/allJobs")
	public AppResponse getAllJobs() {
		
		AppResponse response =AppResponse.builder().build();
		List<AvailableJobs> availableJobs =availableJobsRepo.findAll();
		if(Objects.isNull(availableJobs)|| availableJobs.isEmpty()) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage("No Response Returned");
		}
		response.setResponseObject(availableJobs);
		return response;
	}
	
	@GetMapping("/allJobs")
	public AppResponse createJob(@RequestBody AvailableJobs availableJobs) {
		
		AppResponse response =AppResponse.builder().build();
		if(Objects.isNull(availableJobs)) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage("Invalid Request Returned");
		}
		try {
		availableJobsRepo.save(availableJobs);
		}catch(Exception e) {
			log.info("Exception occured while adding data to DB {}",e.getMessage());
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage("Recorded Inserted Successfully");
		response.setResponseObject(availableJobs);
		return response;
	}
}
