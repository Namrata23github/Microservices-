package com.example.msprice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name ="Price", schema ="schema_shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Price {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private double mrp;
	private double discount;
	private double discountAmount;
	private final double tax = 10.0;
	private double taxAmount;
	private double priceAfterDiscount;
	private double payableAmount;
	
	public void setPayableAmount() {

		this.discountAmount = this.mrp * this.discount/100;
		this.priceAfterDiscount = this.mrp - this.discountAmount;

		this.taxAmount = this.priceAfterDiscount * this.tax/100;
		this.payableAmount = this.priceAfterDiscount + this.taxAmount;
	}
	
	public Price(double mrp, double discount) {
		super();
		this.mrp = mrp;
		this.discount = discount;
		this.setPayableAmount();
	}

	public Price() {
		// TODO Auto-generated constructor stub
	}
}
