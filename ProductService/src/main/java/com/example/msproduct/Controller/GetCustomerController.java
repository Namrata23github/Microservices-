package com.example.msproduct.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.msproduct.Repository.ProductRepositroy;
import com.example.msproduct.entity.Product;
import com.example.msproduct.model.ProductDetail;
import com.example.msproduct.service.ProductService;

@RestController
public  class GetCustomerController {
	
	@Autowired
	ProductRepositroy productRepositroy;
	
	@Autowired
	ProductService productService;


	
	@GetMapping("/api/v1.o/product/get/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> productList = new ArrayList<>();
		productList=	productRepositroy.findAll();
		if(productList!=null && productList.size()>0) {
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Product>>(productList, HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/api/v1.o/product/get/byid")
	public ResponseEntity<Product> getFindById(@RequestParam(value= "id") String ProductId) {
		Long id = Long.valueOf(ProductId);
			Optional< Product> optional=	productRepositroy.findById(id);
			Product product = optional.orElse(new Product());
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/api/v1.0/product/fetch/item/detail")
	public ResponseEntity<ProductDetail> fetchProductAndPrice(
			@RequestParam(name="productId", defaultValue="0") final Long productId){
		
		if(productId == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ProductDetail productDetails = productService.fetchProductDetails(productId);
		
		return new ResponseEntity<ProductDetail>(productDetails, HttpStatus.OK);
	}
	

	@GetMapping("/api/v1.0/fetch/product")
	public ResponseEntity<List<Product>> fetchProductList(@RequestParam String category){
		
		try{
			List<Product> productList = productService.fetchProductByCategory(category);
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		}
		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
