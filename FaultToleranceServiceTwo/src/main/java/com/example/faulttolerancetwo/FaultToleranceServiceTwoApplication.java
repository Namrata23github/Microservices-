package com.example.faulttolerancetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FaultToleranceServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaultToleranceServiceTwoApplication.class, args);
	}

}

