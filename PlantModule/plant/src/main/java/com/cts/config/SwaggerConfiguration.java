package com.cts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	public static final Contact DEFAULT_CONTACT = new Contact("Plant Service", "https://www.plant.com", "plant@cognizant.com");
	public static final ApiInfo RFQ_DEFAULT = new ApiInfo("Plant DOCUMENTATION", "This Documentation is for plant Project","1.0", "urn-tos", "API RFQ 1.0", "https://www.plant.com", null);
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(RFQ_DEFAULT);
	}

}
