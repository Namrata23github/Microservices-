package com.example.msproduct.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductPrice {
private Long id;
	
	private double mrp = 0.0;
	private double discount= 0.0;
	private double discountAmount = 0.0;
	private final double tax = 10.0;
	private double taxAmount= 0.0;
	private double priceAfterDiscount= 0.0;
	private double payableAmount= 0.0;
}
