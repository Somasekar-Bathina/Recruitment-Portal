package com.project.fdb.Recruitment.Portal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fdb.Recruitment.Portal.Model.AppResponse;

@RestController
@RequestMapping("/RP")
public class CandidateController {


	@GetMapping("/getCandidateDetails")
	public AppResponse getCandidateDetails(@RequestHeader Integer candidateId) {
			return null;
	}
}
