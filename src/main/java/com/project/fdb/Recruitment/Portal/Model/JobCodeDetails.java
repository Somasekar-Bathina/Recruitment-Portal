package com.project.fdb.Recruitment.Portal.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "jobcode_details")
@AllArgsConstructor
@NoArgsConstructor
public class JobCodeDetails {

	@Id
	@Column(name = "jobcode_id")
	private Integer jobcode_id;
	
	@Column(name = "jobcode_description")
	private String jobcode_description;
	
	@Column(name = "last_updated_timestamp")
	private Timestamp last_updated_timestamp;
	
	
	
}
