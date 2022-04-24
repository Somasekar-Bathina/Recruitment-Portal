package com.project.fdb.Recruitment.Portal.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
	
	@Column(name  = "candidate_id")
	private Integer candidate_id;
	
	@Column(name = "company_name")
	private String  company_name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateWorkId other = (CandidateWorkId) obj;
		return Objects.equals(candidate_id, other.candidate_id) && Objects.equals(company_name, other.company_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidate_id, company_name);
	}
}
