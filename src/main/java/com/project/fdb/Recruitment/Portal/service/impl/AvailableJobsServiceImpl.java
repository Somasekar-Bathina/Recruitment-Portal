package com.project.fdb.Recruitment.Portal.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.CandidateAvaialableJobResponse;
import com.project.fdb.Recruitment.Portal.repository.AvailableJobsRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateApplicationRepository;
import com.project.fdb.Recruitment.Portal.service.AvailableJobsService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AvailableJobsServiceImpl implements AvailableJobsService{

	@Autowired
	private AvailableJobsRepository availableJobsRepo;
	
	@Autowired
	private CandidateApplicationRepository candRepo;
	
	@Override
	public AppResponse getCandidateAvailableJobs(Integer candidateId) {
		
		CandidateAvaialableJobResponse candidateAvailableJobResponse = CandidateAvaialableJobResponse.builder().build();
		AppResponse response = AppResponse.builder().build();
		List<AvailableJobs> appliedJobs = null;
		List<AvailableJobs> openJobs =null;
		try {
			List<AvailableJobs> availableJobs = availableJobsRepo.findActiveJobs();
			List<CandidateApplication> candApplicationlist = candRepo.getCandidateApplicationDetails(candidateId);
			candidateAvailableJobResponse.setCandidateId(candidateId);
			if(availableJobs.isEmpty()) {
				response.setResponseCode(RPConstants.BAD_REQUEST_4XX_CODE);
				response.setResponseMessage("No Jobs Available ");
				return response;
			}
			availableJobs.stream()
			.forEach((job)->{
				
				if(findByJobId(job,candApplicationlist)) {
					appliedJobs.add(job);
				}else {
					openJobs.add(job);
				}
			});
		}catch(Exception e) {
			log.info("Exception occured while getting candidate available jobs{}",e.getMessage());
		}
		
		
		return response;
	}

	private boolean findByJobId(AvailableJobs job, List<CandidateApplication> candApplication) {
		AtomicReference<Integer> flag=new AtomicReference<>();
		candApplication.stream()
		.forEach((candAppl)->{
			if(candAppl.getCandApplicationId().getJob_id()==job.getJob_id()) {
				flag.set(1);
				return ;
			}
		});
		
		return flag.get()==1?true:false;
	}

}
