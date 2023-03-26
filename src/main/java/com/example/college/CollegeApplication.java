package com.example.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.reactive.function.client.*;

@SpringBootApplication
public class CollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
}
