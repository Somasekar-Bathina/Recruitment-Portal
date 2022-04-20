package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;
import com.project.fdb.Recruitment.Portal.Model.CandidateAvaialableJobResponse;

@Repository
public interface AvailableJobsRepository extends JpaRepository<AvailableJobs, Integer>{

	public CandidateAvaialableJobResponse getCandidateAppliedJobs(@Param("candidateId") Integer candidateId );
}
