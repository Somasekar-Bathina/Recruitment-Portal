package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.CandidateDetails;

@Repository
public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails, Integer>{

}
