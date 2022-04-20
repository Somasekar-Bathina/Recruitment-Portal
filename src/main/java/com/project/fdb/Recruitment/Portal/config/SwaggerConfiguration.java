package com.project.fdb.Recruitment.Portal.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@PropertySource("classpath:application.properties")
public class SwaggerConfiguration {
	
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("Recruitment Portal")
	              .pathsToMatch("/**")
	              .build();
	  }
	  @Bean
	  public GroupedOpenApi adminApi() {
	      return GroupedOpenApi.builder()
	              .group("Recruitment Portal-admin")
	              .pathsToMatch("/**")
	              .build();
	  }

}
