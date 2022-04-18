package com.project.fdb.Recruitment.Portal.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppResponse<T> {

	private String responseCode;
	
	private String responseMessage;
	
	public T responseObject;
	
	
	
}
