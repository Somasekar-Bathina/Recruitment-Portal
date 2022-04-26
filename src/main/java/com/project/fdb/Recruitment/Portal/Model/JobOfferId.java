package com.project.fdb.Recruitment.Portal.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOfferId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "job_offer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobOfferId;
	
	@Column(name = "job_id")
	private Integer jobId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOfferId other = (JobOfferId) obj;
		return Objects.equals(jobId, other.jobId) && Objects.equals(jobOfferId, other.jobOfferId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobId, jobOfferId);
	}

	
	
}
