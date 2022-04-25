package com.project.fdb.Recruitment.Portal.service;

import java.util.List;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;
import com.project.fdb.Recruitment.Portal.Model.CandidateQualification;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;

public interface CandidateService {

	public AppResponse getCandidateDetails(Integer candidateId);

	public AppResponse addCandidateDetails(CandidateDetails candidateDetails);
	
	public AppResponse saveEducationalDetails(List<CandidateQualification> candidateQualDetails);
	
	public AppResponse saveWorkExpDetails(List<CandidateWorkExperience> candidateWorkDetails);
}
