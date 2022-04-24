package com.project.fdb.Recruitment.Portal.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateQualificationId {

	@Id
	@Column(name="candidate_id")
	private Integer candidate_id;
	
	@Id
	@Column(name="qualification_type")
	private String qualification_type;
}
