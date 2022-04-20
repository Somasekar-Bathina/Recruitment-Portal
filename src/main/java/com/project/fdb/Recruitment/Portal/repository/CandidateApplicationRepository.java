package com.project.fdb.Recruitment.Portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateApplication;
import com.project.fdb.Recruitment.Portal.Model.CandidateApplicationId;

@Repository
public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication,CandidateApplicationId>{

	@Query(value = "select * from candidate_application where candidate_id=:candidate_id",nativeQuery=true)
	public List<CandidateApplication> getCandidateApplicationDetails(@Param("candidate_id")Integer candidateId);
}
