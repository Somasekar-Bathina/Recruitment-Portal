package com.project.fdb.Recruitment.Portal.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
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
			AvailableJobs jobDetails=  availableJobRepo.findByJobId(candidateApplication.getCandApplicationId().getJob_id());
			if(Objects.isNull(jobDetails)
					|| jobDetails.getStatus_code()==113) {
				response.setResponseMessage(RPConstants.JOB_ID_EXPIRED_OR_INVALID);
				return response;
			}
			candidateApplication.setStatus_code(RPConstants.PENDING_ASSESSMENT_CODE);
			if(jobDetails.getStatus_code()==112) {
				candidateApplication.setJob_status(RPConstants.OPEN);
			}
			long now = Instant.now().toEpochMilli();
			Timestamp currentTimeStamp =new Timestamp(now);
			candidateApplication.setApplied_date(currentTimeStamp);
			candidateApplication.setLast_updated_timestamp(currentTimeStamp);
			candApplRepo.save(candidateApplication);
		}catch(Exception e) {
			log.info("Exception occured While applying job for candidate Application: {}, {}",candidateApplication,e.getMessage());
		}
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.JOB_APPLIED_SUCCESSFULLY);
		log.info("Apply Job is Success for candidate Id {} and jobId {}",candidateApplication.getCandApplicationId().getCandidate_id(),candidateApplication.getCandApplicationId().getJob_id());
		return response;
	}
	
	private boolean checkIfAlreadyApplied(CandidateApplication candAppl) {
		
		CandidateApplication iscandAppExist=null;
		CandidateApplicationId applId=candAppl.getCandApplicationId(); 
		try {
			iscandAppExist = candApplRepo.findByCandidateApplicationId(applId.getCandidate_id(),applId.getJob_id());
			if(Objects.isNull(iscandAppExist)) {
				return false;
			}
		}catch(Exception e) {
			log.info("Exception occured while checking whether candidate application is exist for candidate Application {} ,{}",candAppl,e.getMessage());
		}
		log.info("Candidate {} already applied to the Job ID:{}",applId.getCandidate_id(),applId.getJob_id());
		return true;
	}

}
