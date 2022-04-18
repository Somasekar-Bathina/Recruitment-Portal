package com.project.fdb.Recruitment.Portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RecruitmentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentPortalApplication.class, args);
	}

}
