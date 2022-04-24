package com.project.fdb.Recruitment.Portal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;
import com.project.fdb.Recruitment.Portal.repository.CandidateDetailsRepository;
import com.project.fdb.Recruitment.Portal.service.CandidateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateDetailsRepository candRepo;

	public AppResponse getCandidateDetails(Integer candidateId) {
		try {
		Optional<CandidateDetails> candDetails = candRepo.findById(candidateId);
//		Optional<CandidateWorkExperience> workExp 
		}catch(Exception e) {
			log.info("Exception Occured while fetching candidate Details {}",e.getMessage());
		}
		return null;
	}
}
