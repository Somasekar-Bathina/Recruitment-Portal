package com.project.fdb.Recruitment.Portal.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplicationId;
import com.project.fdb.Recruitment.Portal.repository.AvailableJobsRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateApplicationRepository;
import com.project.fdb.Recruitment.Portal.service.JobService;
import com.project.fdb.Recruitment.Portal.utilities.ApplicationUtil;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobServiceImpl implements JobService{
	
	@Autowired
	private CandidateApplicationRepository candApplRepo;
	
	@Autowired
	private AvailableJobsRepository availableJobRepo;
	
	public AppResponse applyJob(CandidateApplication candidateApplication) {
		
		AppResponse response = AppResponse.builder().responseCode(RPConstants.BAD_REQUEST_4XX_CODE).build();
		
		if(checkIfAlreadyApplied(candidateApplication)) {
			response.setResponseMessage(RPConstants.CANDIDATEAPPLCIATION_ALREADY_EXIST);
			return response;
		}
		try {
			Optional<AvailableJobs> jobDetails=  Optional.ofNullable(availableJobRepo.findById(candidateApplication.getCandApplicationId().getCandidate_id())).orElse(null);
			if(Objects.isNull(jobDetails)
					|| jobDetails.get().getStatus_code()==113) {
				response.setResponseMessage(RPConstants.JOB_ID_EXPIRED_OR_INVALID);
				return response;
			}
			candidateApplication.setStatus_code(RPConstants.PENDING_ASSESSMENT_CODE);
			if(jobDetails.get().getStatus_code()==112) {
				candidateApplication.setJob_status(RPConstants.OPEN);
			}
			long now = Instant.now().toEpochMilli();
			Timestamp last_updated_timeTimestamp =new Timestamp(now);
			candidateApplication.setApplied_date(ApplicationUtil.getCurrentTimeStamp());
			candidateApplication.setLast_updated_timestamp(last_updated_timeTimestamp);
			candApplRepo.save(candidateApplication);
		}catch(Exception e) {
			log.info("Exception occured While applying job for candidate Application: {}, {}",candidateApplication,e.getMessage());
		}
		return response;
	}
	
	private boolean checkIfAlreadyApplied(CandidateApplication candAppl) {
		
		Optional<CandidateApplication> iscandAppExist=null;
		CandidateApplicationId applId=candAppl.getCandApplicationId(); 
		try {
			iscandAppExist = Optional.ofNullable(candApplRepo.findById(applId)).orElse(null);
			if(Objects.isNull(iscandAppExist)
					|| Objects.isNull(iscandAppExist.get())) {
				return false;
			}
		}catch(Exception e) {
			log.info("Exception occured while checking whether candidate application is exist for candidate Application {} ,{}",candAppl,e.getMessage());
		}
		log.info("Candidate {} already applied to the Job ID:{}",applId.getCandidate_id(),applId.getJob_id());
		return true;
	}

}
