//package com.project.fdb.Recruitment.Portal.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//
//
//@Configuration
//@PropertySource("classpath:application.properties")
//public class SwaggerConfiguration {
//	
//	@Bean
//	public Docket api() {                
//	    return new Docket(DocumentationType.SWAGGER_2)  
//	      .groupName("Public")
//	      .select()                                       
//	      .apis(RequestHandlerSelectors.any())
//	      .paths(PathSelectors.ant("/foos/*"))                    
//	      .build();
//	}
//	  
//	  private ApiInfo apiInfo() {
//		    return new ApiInfo(
//		      "My REST API", 
//		      "Some custom description of API.", 
//		      "API TOS", 
//		      "Terms of service", 
//		      null, 
//		      "License of API", "API license URL", Collections.emptyList());
//		}
//
//
//}
