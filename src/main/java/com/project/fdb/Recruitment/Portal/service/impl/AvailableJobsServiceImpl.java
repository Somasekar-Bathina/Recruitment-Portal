package com.project.fdb.Recruitment.Portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateAvaialableJobResponse;
import com.project.fdb.Recruitment.Portal.repository.AvailableJobsRepository;
import com.project.fdb.Recruitment.Portal.service.AvailableJobsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AvailableJobsServiceImpl implements AvailableJobsService{

	@Autowired
	private AvailableJobsRepository availableJobsRepo;
	
	@Override
	public AppResponse getCandidateAvailableJobs(Integer candidateId) {
		
		CandidateAvaialableJobResponse candidateAvailableJobResponse = CandidateAvaialableJobResponse.builder().build();
		
		try {
			
		}catch(Exception e) {
			log.info("Exception occured while getting candidate available jobs{}",e.getMessage());
		}
		
		
		return null;
	}

}
