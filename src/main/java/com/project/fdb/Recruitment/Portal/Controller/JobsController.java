package com.project.fdb.Recruitment.Portal.Controller;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.repository.AvailableJobsRepository;
import com.project.fdb.Recruitment.Portal.service.AvailableJobsService;
import com.project.fdb.Recruitment.Portal.service.JobService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RP")
@Slf4j
@CrossOrigin
public class JobsController {

	
	@Autowired
	private AvailableJobsService availableJobService;
	
	@Autowired
	private AvailableJobsRepository availableJobsRepo;
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/candidate/availableJobs")
	public AppResponse getCandidateAvailableJobs(@RequestHeader Integer candidateId) {
		
		AppResponse response = AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		if(candidateId  == null) {
			response.setResponseMessage("Candidate Id  Is Null");
			return response;
		}
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
	
	@PutMapping("/createJob")
	public AppResponse createJob(@RequestBody AvailableJobs availableJobs) {
		
		AppResponse response =AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		if(Objects.isNull(availableJobs)) {
			response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
			response.setResponseMessage("Invalid Request Returned");
		}
		try {
		//int randomNo = ThreadLocalRandom.current().nextInt(10000, 200000);
		//availableJobs.setJob_id(randomNo);
		availableJobsRepo.save(availableJobs);
		}catch(Exception e) {
			log.info("Exception occured while adding data to DB {}",e.getMessage());
			response.setResponseMessage("Exception occured while crating a new job");
			return response;
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage("Recorded Inserted Successfully");
		response.setResponseObject(availableJobs);
		return response;
	}
	
	@PostMapping("/candidate/applyJob")
	public AppResponse applyJob(@RequestBody CandidateApplication candidateApplication) {
		
		AppResponse response = AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		log.info("Invoked Apply Job Method for Candidate ID:{} and Job ID:{}");
		if(Objects.isNull(candidateApplication)
				|| Objects.isNull(candidateApplication.getCandApplicationId())
				|| Objects.isNull(candidateApplication.getCandApplicationId().getCandidate_id())
				|| Objects.isNull(candidateApplication.getCandApplicationId().getJob_id())) {
			log.info("Apply Job is Invoked with invalid candidateapplication {}",candidateApplication);
			response.setResponseMessage(RPConstants.INVALID_CAND_APPLICATION);
			return response;
		}
		
		return jobService.applyJob(candidateApplication);
		
	}
}
