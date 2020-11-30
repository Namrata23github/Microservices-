package com.example.faulttolerancetwo.indianews;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndiaNews {

	@GetMapping("/in/news")
	public String getToiNews() {
		return "india  news";		
	}
}
