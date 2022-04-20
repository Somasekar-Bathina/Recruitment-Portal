package com.project.fdb.Recruitment.Portal.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class CandidateApplicationId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer candidate_id;
	
	private Integer job_id;
	
}
