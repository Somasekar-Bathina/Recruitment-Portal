package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateApplicationId;
import com.project.fdb.Recruitment.Portal.Model.InterviewDetails;

@Repository
public interface InterviewDetailsRepository extends JpaRepository<InterviewDetails, CandidateApplicationId>{

}
