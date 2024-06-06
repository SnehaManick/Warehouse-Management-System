package com.jsp.whs.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
   @Bean
	public OpenAPI openAPI(){
		return new OpenAPI().info( new Info().title("  Warehouse Management System")
				.version("v1")
				.description(" Warehouse management syatem by using the **RESTful** api" 
						    ));
	}
	
	
	
	
	
}
