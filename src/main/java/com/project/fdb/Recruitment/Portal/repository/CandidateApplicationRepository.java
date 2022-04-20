package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplicationId;

@Repository
public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication,CandidateApplicationId>{

	public CandidateApplication getCandidateApplicationDetails(@Param("candidate_id")Integer candidateId);
}
