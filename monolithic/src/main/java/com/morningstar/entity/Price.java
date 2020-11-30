package com.morningstar.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="price", schema="schema_mono_shopping")
// Annotation for lombak
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


	@OneToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@MapsId //share the Primary Key with its parent table row. Primary Key in Price is Foreign Key in Product
	private Product product;


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


	public void setProduct(Product product2) {
		// TODO Auto-generated method stub
		product = product2;
	}
}
