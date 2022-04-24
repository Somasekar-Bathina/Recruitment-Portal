package com.project.fdb.Recruitment.Portal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.Candidate;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateQualification;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;
import com.project.fdb.Recruitment.Portal.repository.CandidateDetailsRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateQualificationRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateWorkExpRepo;
import com.project.fdb.Recruitment.Portal.service.CandidateService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateDetailsRepository candRepo;
	
	@Autowired
	private CandidateWorkExpRepo candWorkRepo;
	
	@Autowired
	private CandidateQualificationRepository candQualRepo;

	public AppResponse getCandidateDetails(Integer candidateId) {
		AppResponse response = AppResponse.builder()
				.responseCode(RPConstants.BAD_REQUEST_4XX_CODE)
				.build();
		Candidate candidate = Candidate.builder().build();
		try {
		Optional<CandidateDetails> candDetails = candRepo.findById(candidateId);
		List<CandidateWorkExperience> workExp = candWorkRepo.getWorkExperienceList(candidateId);
		List<CandidateQualification> candQual = candQualRepo.getQualificationList(candidateId);
		candidate=  Candidate.builder()
					.candidateDetails(candDetails.isPresent()?candDetails.get():null)
					.workExperience(workExp)
					.candQualifications(candQual)
					.build();
		response.setResponseCode(RPConstants.SUCCESS_2XX_CODE);
		response.setResponseMessage(RPConstants.USER_PROFILE_FETCHED_SUCCESSFULLY);
		response.setResponseObject(candidate);
		}catch(Exception e) {
			log.info("Exception Occured while fetching candidate Details {}",e.getMessage());
		}
		return response;
	}

	@Override
	public AppResponse addCandidateDetails(CandidateDetails candidateDetails) {
		
		CandidateDetails candDetails =null;
		try {
			candDetails = candRepo.getById(candidateDetails.getCandidateId());
		}catch(Exception e) {
			log.info("Exception occured while adding candidateDetails {}",e.getMessage());
		}
		return null;
	}
}
