package com.example.msproduct.service.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.msproduct.model.ProductPrice;
//String url = "http://price-service/api/v1.0/price/fetch?productId="+prodId;

@Service
public class PriceTemplate {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;
	
	public ProductPrice fetchPrice(final Long prodId) {
				
		
		String url = "http://price-service/api/v1.o/price/get/byid?id="+prodId;
		System.out.println("Calling URL: " + url);
		
		ProductPrice productPrice = restTemplate.getForObject(url, ProductPrice.class);
		
		return productPrice;
	}
}
