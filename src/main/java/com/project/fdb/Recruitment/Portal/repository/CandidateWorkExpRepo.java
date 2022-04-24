package com.project.fdb.Recruitment.Portal.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateWorkExperience;
import com.project.fdb.Recruitment.Portal.Model.CandidateWorkId;

@Repository
public interface CandidateWorkExpRepo extends JpaRepository<CandidateWorkExperience, CandidateWorkId>{

	@Query(value = "select * from candidate_work_experience where candidate_id=:candidateId",nativeQuery = true)
	public List<CandidateWorkExperience> getWorkExperienceList(@Param("candidateId") Integer candidateId);

}
