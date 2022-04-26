package com.project.fdb.Recruitment.Portal.service.impl;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplicationId;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.InterviewDetails;
import com.project.fdb.Recruitment.Portal.repository.CandidateApplicationRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateDetailsRepository;
import com.project.fdb.Recruitment.Portal.repository.InterviewDetailsRepository;
import com.project.fdb.Recruitment.Portal.service.InterviewService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewDetailsRepository interviewRepo;
	
	@Autowired
	private CandidateApplicationRepository candRepo;
	
	@Override
	public AppResponse scheduleInterview(InterviewDetails interviewDetails) {
		
		AppResponse response = AppResponse.builder().build();
		CandidateApplication canDetails =CandidateApplication.builder().build();
		CandidateApplicationId candidateId = interviewDetails.getCandAppId();
		try {
			long now = Instant.now().toEpochMilli();
			Timestamp currentTimeStamp =new Timestamp(now);
			interviewDetails.setStatus_code(114);
			interviewDetails.setLast_updated_timestamp(currentTimeStamp);
			interviewRepo.save(interviewDetails);
			canDetails = candRepo.findByCandidateApplicationId(candidateId.getCandidate_id(),candidateId.getJob_id());
			canDetails.setStatus_code(114);
			candRepo.save(canDetails);
		}catch(Exception e) {
			log.info("Exception occured while scheduling interview for candidate ID {} , {}",interviewDetails.getCandAppId(), e.getMessage());
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage("InterviewScheduled Successfully");
		return response;
	}

}
