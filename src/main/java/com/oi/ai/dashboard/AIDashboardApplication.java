package com.oi.ai.dashboard;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.oi.ai")
public class AIDashboardApplication {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(AIDashboardApplication.class);

	@Value("${service.timezone}")
	String timeZone;

	public static void main(String[] args) {
		SpringApplication.run(AIDashboardApplication.class, args);

	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		LOGGER.info("*****************AI DASHBOARD SERVICE TIME ZONE {}",
				timeZone);

	}

	@Bean
	public ObjectMapper jsonObjectMapper() {
		return Jackson2ObjectMapperBuilder
				.json()
				.serializationInclusion(JsonInclude.Include.NON_NULL)
				// Don’t include
				.featuresToDisable(
						SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISODate
				.modules(new JavaTimeModule()).build();
	}

	/**
	 * Open API documentation configuration
	 * 
	 * @return
	 */
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(
				new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP)
								.scheme("basic"))).info(
				new Info().title("AI DASHBOARD SERVICE APIs").version("v1"));
	}

	static {
		SpringDocUtils.getConfig().addHiddenRestControllers(
				BasicErrorController.class);
	}

}
