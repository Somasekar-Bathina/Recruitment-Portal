package com.project.fdb.Recruitment.Portal.service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;

public interface JobService {
	
	public AppResponse applyJob(CandidateApplication candidateApplication);

}
