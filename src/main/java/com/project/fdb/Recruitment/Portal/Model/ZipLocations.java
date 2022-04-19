package com.project.fdb.Recruitment.Portal.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "zip_locations")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZipLocations {

	@Id
	private Integer zipcode;
	
	private String city;
	
	private String state;
	
	private String country;
	
}
