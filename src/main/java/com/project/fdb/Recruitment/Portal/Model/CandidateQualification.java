package com.project.fdb.Recruitment.Portal.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_qualification")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateQualification {

	
	@EmbeddedId
	private CandidateQualificationId candQualId;
	
	@Column(name = "institute_name")
	private String institute_name;
	
	@Column(name = "passing_year")
	private Integer yearOfPassing;
}
