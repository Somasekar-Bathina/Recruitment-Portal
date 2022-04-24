package com.project.fdb.Recruitment.Portal.service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;

public interface CandidateService {

	public AppResponse getCandidateDetails(Integer candidateId);

	public AppResponse addCandidateDetails(CandidateDetails candidateDetails);
}
