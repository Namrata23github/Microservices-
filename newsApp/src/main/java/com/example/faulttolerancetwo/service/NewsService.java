package com.example.faulttolerancetwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class NewsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallbackmethodIndiaNews")
	public String getNewsFromTOI() {
		String url ="http://toiservice/toi/news";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		return response.getBody();
	}
	
	
	public String fallbackmethodIndiaNews() {
		String url ="http://indianews/in/news";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		return response.getBody();
	}

}
