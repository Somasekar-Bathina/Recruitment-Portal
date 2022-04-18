package com.project.fdb.Recruitment.Portal.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@PropertySource("classpath:application.properties")
public class SwaggerConfiguration {
	
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("EMS Application-Public")
	              .pathsToMatch("/*")
	              .build();
	  }
	  @Bean
	  public GroupedOpenApi adminApi() {
	      return GroupedOpenApi.builder()
	              .group("EMS Application-admin")
	              .pathsToMatch("/**")
	              .build();
	  }

}
