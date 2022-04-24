package com.project.fdb.Recruitment.Portal.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "candidate_work_experience")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWorkExperience {

	@EmbeddedId
	private CandidateWorkId candidateWorkId;
	
	@Column(name = "years")
	private String years;
}
