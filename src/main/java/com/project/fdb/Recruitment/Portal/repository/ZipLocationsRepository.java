package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.ZipLocations;

@Repository
public interface ZipLocationsRepository extends JpaRepository<ZipLocations, Integer>{

}
