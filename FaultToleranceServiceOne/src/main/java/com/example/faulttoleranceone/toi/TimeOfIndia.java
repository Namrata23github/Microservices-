package com.example.faulttoleranceone.toi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeOfIndia {
	
	@Value("${server.port}")
	private String serverport;
	
	@GetMapping("/toi/news")
	public String getToiNews() {
		
		System.out.println("++++++++++++++LOCALHOST++++++++++++++++++"+serverport);
		return "Times of news";		
	}

}
