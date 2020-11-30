package com.example.msproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.msproduct.Repository.ProductRepositroy;
import com.example.msproduct.entity.Product;

@RestController
public class PostCustomerController {
	
	@Autowired
	ProductRepositroy productRepositroy;
	
	@PostMapping("/api/v1.0/save/product")
	public ResponseEntity<Product> saveCustomer(@RequestParam(value = "category") String category, @RequestParam(value= "model") String Model,@RequestParam(value = "productname") String productname, @RequestParam(value ="status") String status){
		Product product = new Product(category,Model,productname,status);
		
		productRepositroy.save(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	}


