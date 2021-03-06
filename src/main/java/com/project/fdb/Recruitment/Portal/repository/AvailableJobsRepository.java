package com.project.fdb.Recruitment.Portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.AvailableJobs;

@Repository
public interface AvailableJobsRepository extends JpaRepository<AvailableJobs, Integer>{

	@Query(value = "select * from available_jobs where status_code=112",nativeQuery = true)
	public List<AvailableJobs> findActiveJobs();
	
	@Query(value = "select * from available_jobs where job_id=:jobId",nativeQuery=true)
	public AvailableJobs findByJobId(@Param("jobId")Integer jobId);
}
