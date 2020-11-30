package com.example.msprice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.msprice.Repository.PriceRepositroy;
import com.example.msprice.entity.Price;

@RestController
public class PostCustomerController {
	
	@Autowired
	PriceRepositroy productRepositroy;
	
	@PostMapping("/api/v1.0/save/price")
	public ResponseEntity<Price> saveCustomer(@RequestParam(value = "mrp") String mrp, @RequestParam(value= "discount") String discount){
		Double mrpv = Double.valueOf(mrp);
		Double discountv = Double.valueOf(discount);

		Price price = new Price(mrpv, discountv);
		
		productRepositroy.save(price);
		return new ResponseEntity<Price>(price, HttpStatus.OK);
	}
		
		
	}


