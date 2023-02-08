package com.wecode.main.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Java Testing APIs").apiInfo(apiInfo()).select()
				.paths(regex("/api/v1.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our Student Rest API")
				.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
				.license("Java_Gyan_Mantra License")
				.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}

}