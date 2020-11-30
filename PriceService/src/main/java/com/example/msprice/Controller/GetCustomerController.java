package com.example.msprice.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.msprice.Repository.PriceRepositroy;
import com.example.msprice.entity.Price;

@RestController
public  class GetCustomerController {
	
	@Value("$(server.port)")
	private String serverPort;
	
	@Autowired
	PriceRepositroy priceRepositroy;
	
	@GetMapping("/api/v1.o/price/get/all")
	public ResponseEntity<List<Price>> getAllProducts(){
		List<Price> priceList = new ArrayList<>();
		priceList=	priceRepositroy.findAll();
		if(priceList!=null && priceList.size()>0) {
			return new ResponseEntity<List<Price>>(priceList, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Price>>(priceList, HttpStatus.NOT_FOUND);

		}	
	}
	
	@GetMapping("/api/v1.o/price/get/byid")
	public ResponseEntity<Price> getFindById(@RequestParam(value= "id") String PriceId) {
		Long id = Long.valueOf(PriceId);
			Optional< Price> optional=	priceRepositroy.findById(id);
			Price price = optional.orElse(new Price());
		
			System.out.println("+++++++++++port number++++++++++"+serverPort);
			return new ResponseEntity<Price>(price, HttpStatus.OK);
		
		
	}

}
