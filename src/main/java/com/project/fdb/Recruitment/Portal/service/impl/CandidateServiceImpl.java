package com.project.fdb.Recruitment.Portal.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.Candidate;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateQualification;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;
import com.project.fdb.Recruitment.Portal.Model.ZipLocations;
import com.project.fdb.Recruitment.Portal.repository.CandidateDetailsRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateQualificationRepository;
import com.project.fdb.Recruitment.Portal.repository.CandidateWorkExpRepo;
import com.project.fdb.Recruitment.Portal.repository.ZipLocationsRepository;
import com.project.fdb.Recruitment.Portal.service.CandidateService;
import com.project.fdb.Recruitment.Portal.utilities.RPConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateDetailsRepository candRepo;
	
	@Autowired
	private ZipLocationsRepository zipRepo;
	
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
			updateCandidateDetails(candidateDetails,candDetails);
			candRepo.save(candDetails);
			log.info("Candidate Details Updated Successfully");
		}catch(Exception e) {
			log.info("Exception occured while adding candidateDetails {}",e.getMessage());
		}
		return null;
	}
	
	private void updateCandidateDetails(CandidateDetails candidateDetails,CandidateDetails existingCandDetails) {
		
		if(StringUtils.isNotEmpty(candidateDetails.getFirst_name())){
			existingCandDetails.setFirst_name(candidateDetails.getFirst_name());
		}
		if(StringUtils.isNotEmpty(candidateDetails.getLast_name())){
			existingCandDetails.setLast_name(candidateDetails.getLast_name());
		}
		if(StringUtils.isNotEmpty(candidateDetails.getAddress_line1())){
			existingCandDetails.setAddress_line1(candidateDetails.getAddress_line1());
		}
		if(StringUtils.isNotEmpty(candidateDetails.getAddress_line2())){
			existingCandDetails.setAddress_line2(candidateDetails.getAddress_line2());
		}
		if(StringUtils.isNotEmpty(candidateDetails.getGender())){
			existingCandDetails.setGender(candidateDetails.getGender());
		}
		if(StringUtils.isNotEmpty(candidateDetails.getPhonenumber())){
			existingCandDetails.setPhonenumber(candidateDetails.getPhonenumber());
		}
		if(Objects.nonNull(candidateDetails.getDob())){
			existingCandDetails.setDob(candidateDetails.getDob());
		}
		if(Objects.nonNull(candidateDetails.getZipcode() )&& Objects.nonNull(candidateDetails.getZipcode().getZipcode())){
			updateZipLocation(candidateDetails.getZipcode());
			existingCandDetails.setZipcode(candidateDetails.getZipcode());
		}
	}
	
	private void updateZipLocation(ZipLocations ziplocation) {
		
		Optional<ZipLocations> zipLocation = null;
		try {
			zipLocation = zipRepo.findById(ziplocation.getZipcode());
			if(zipLocation.isPresent()) {
				log.info("Location already exists in DB");
				return;
			}
			zipRepo.save(ziplocation);
			log.info("New Location is added to DB");
		}catch(Exception e) {
			log.info("Exception occured while updating zip location {}",e.getMessage());
		}
	}
}
