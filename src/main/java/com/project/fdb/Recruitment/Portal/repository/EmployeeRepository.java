package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fdb.Recruitment.Portal.Model.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

}
