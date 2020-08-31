package com.cadsdanaa.sleuthexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SleuthExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthExampleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("${otherserver.url}") String otherServerBaseUrl) {
		return new RestTemplateBuilder().rootUri(otherServerBaseUrl).build();
	}

}
