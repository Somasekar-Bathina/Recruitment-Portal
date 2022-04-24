package com.project.fdb.Recruitment.Portal.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateWorkId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name  = "candidate_id")
	private Integer candidate_id;
	
	@Id
	@Column(name = "company_name")
	private String  company_name;
}
