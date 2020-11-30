package com.example.msprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class PriceServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate geTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}

