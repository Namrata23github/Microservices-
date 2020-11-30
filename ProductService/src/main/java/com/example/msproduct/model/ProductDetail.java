package com.example.msproduct.model;

import com.example.msproduct.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDetail {
	
	public ProductDetail(Product product, ProductPrice productPrice) {
		super();
		this.product = product;
		this.productPrice = productPrice;
	}
	Product product;
	ProductPrice productPrice;

}
