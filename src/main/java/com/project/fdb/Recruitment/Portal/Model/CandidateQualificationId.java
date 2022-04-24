package com.project.fdb.Recruitment.Portal.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateQualificationId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="candidate_id")
	private Integer candidate_id;
	
	@Column(name="qualification_type")
	private String qualification_type;

	@Override
	public int hashCode() {
		return Objects.hash(candidate_id, qualification_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateQualificationId other = (CandidateQualificationId) obj;
		return Objects.equals(candidate_id, other.candidate_id)
				&& Objects.equals(qualification_type, other.qualification_type);
	}
}
