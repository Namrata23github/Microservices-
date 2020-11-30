package com.example.faulttolerancetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.faulttolerancetwo.service.NewsService;

@RestController
public class GetNewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/newsapp/get")
	public String getNews() {
	return newsService.getNewsFromTOI();
	}

}
