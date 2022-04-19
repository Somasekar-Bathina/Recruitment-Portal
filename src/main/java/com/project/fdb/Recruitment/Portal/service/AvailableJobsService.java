package com.project.fdb.Recruitment.Portal.service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;

public interface AvailableJobsService {

	public AppResponse getCandidateAvailableJobs(Integer candidateId);
}
