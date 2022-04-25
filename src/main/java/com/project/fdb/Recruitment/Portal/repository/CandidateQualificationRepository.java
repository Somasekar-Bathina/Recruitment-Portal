package com.project.fdb.Recruitment.Portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateQualification;
import com.project.fdb.Recruitment.Portal.Model.CandidateQualificationId;

@Repository
public interface CandidateQualificationRepository extends JpaRepository<CandidateQualification, CandidateQualificationId>{

	@Query(value = "select * from candidate_qualification where candidate_id=:candidateId",nativeQuery = true)
	public List<CandidateQualification> getQualificationList(@Param("candidateId") Integer candidateId);

	@Query(value ="select * from candidate_qualification where candidate_id=:candidateId and qualification_type=:qualType",nativeQuery=true)
	public CandidateQualification findByCandidateQualId(@Param("candidateId")Integer candidateId,@Param("qualType")String qualificationType);

}
