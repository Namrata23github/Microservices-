package com.example.faulttoleranceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FaultToleranceServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaultToleranceServiceOneApplication.class, args);
	}

}

