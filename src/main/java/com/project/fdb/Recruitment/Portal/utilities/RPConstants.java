package com.project.fdb.Recruitment.Portal.utilities;

import org.springframework.stereotype.Component;


@Component
public class RPConstants {

	public static final String INVALID_CREDENTIALS = "Please Provide Valid Credentials to Sign Up!";
	public static final String SUCCESS = "Success";
	public static final String LOGIN_SUCCESSFULL =  "Login Successfull";
	public static final String SUCCESS_2XX_CODE = "200";
	public static final String BAD_REQUEST_4XX_CODE = "400";
	public static final String USER_ALREADY_EXIST = "User Already Exists, Please login with your Username/email";
	public static final String USER_CREATED = "User Account has been created successfully";
	public static final String CANDIDATE = "Candidate";
	public static final String INVALID_LOGIN_CREDENTIALS = "Username/Password is Incorrect";
	public static final String DEFAULT_PASSWORD_MAIL = "Check Your Email for Password Reset";
	public static final String USER_ACCOUNT_NOT_FOUND = "No User Account associated with the given emailId";
	public static final String INVALID_EMAIL_ID = "Provide a Valid Email Id to reset Password";
	public static final String INVALID_USERNAME = "Provided Username is Invalid/Empty";
	public static final String RELOGIN = "User Profile is not found.Try Logging in Again!";
	public static final String USER_PROFILE_FETCHED_SUCCESSFULLY = "User Profile Fetched Successfully";
	public static final String NO_ACTIVE_EVENTS = "No Active Events";
	public static final String FETCHED_ACTIVE_EVENTS = "Fetched Active Events";
	public static final String USER_PROFILE_UPDATED_SUCCESSFULLY = "User Profile Updated Successfully";
	public static final String ERROR_WHILE_UPDATING_PROFILE = "Error While Updaitng Profile";
	public static final String INCORRECT_EVENT_DETAILS = "Incorrect Event Details";
	public static final String EVENT_CREATION_FAILED = "Event Creation Failed";
	public static final String EVENT_CREATED_SUCCESSFULLY = "EVENT_CREATED_SUCCESSFULLY";
	public static final String USER_PASSWORD_UPDATED_SUCCESSFULLY = "USER PASSWORD UPDATED SUCCESSFULLY";
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	public static final String OTHERS = "Others";
	public static final String INVALID_EDUCATIONDETAILS = "Invalid Education Details.Please Provide Valid Details!!";
	public static final String SAVE_EDUCATION_DETAILS_FAILED = "Save Education Details Failed";
	public static final String INVALID_WORK_EXPERIENCE = "Invalid WorkExperience Details.Please Provide Valid Details!!";
	public static final String SAVE_WORK_DETAILS_FAILED = "Save Work Details Failed";
	public static final String SAVE_WORK_DETAILS_SUCCESSFULL = "Save Work Details Successfull";
	public static final String SAVE_EDUCATION_DETAILS_SUCCESSFULL = "Save Education Details Successfull";
	public static final String INVALID_CAND_APPLICATION="Invalid Candidate Application. Please Provide Valid Candidate Application";
	public static final String CANDIDATEAPPLCIATION_ALREADY_EXIST ="CANDIDATEAPPLCIATION_ALREADY_EXIST";
	public static final Integer CANDIDATE_APPLICATION_CREATED_CODE = 101;
	public static final Integer JOB_ID_CLOSED = 112;
	public static final String JOB_ID_EXPIRED_OR_INVALID = "Job Id is expired or Invalid";
	public static final Integer PENDING_ASSESSMENT_CODE=102;
	public static final String OPEN="OPEN";
	public static final String CLOSED="CLOSED";
	public static final String JOB_APPLIED_SUCCESSFULLY = "Job Applied Successfully";
	public static final Integer CANDIDATE_DETAILS_STEP_NUMBER = 1;
}
