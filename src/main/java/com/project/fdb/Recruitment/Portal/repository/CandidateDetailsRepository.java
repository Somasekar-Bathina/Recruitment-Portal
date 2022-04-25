package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;

@Repository
public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails, Integer>{

	@Query(value = "select * from candidate_details where email=:email",nativeQuery = true)
	public CandidateDetails getCandidateDetails(@Param("email") String email);

	@Query(value = "select * from candidate_details where candidate_id=:candidateId",nativeQuery=true)
	public CandidateDetails findByCandidateId(@Param("candidateId") Integer candidateId);
}
