package com.project.fdb.Recruitment.Portal.service;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;
import com.project.fdb.Recruitment.Portal.Model.InterviewDetails;

public interface InterviewService{
	
	public AppResponse scheduleInterview(InterviewDetails interviewDetails);

}
