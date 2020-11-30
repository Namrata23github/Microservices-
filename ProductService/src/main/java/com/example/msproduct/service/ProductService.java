package com.example.msproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.msproduct.entity.Product;
import com.example.msproduct.model.ProductDetail;

@Service
public interface ProductService {

	Product addProduct(Product product);
	
	Product fetchProductById(final Long id);
	
	ProductDetail fetchProductDetails(final Long productId);
	
	List<Product> fetchProductByCategory(String category);
}
