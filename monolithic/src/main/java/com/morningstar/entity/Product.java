package com.morningstar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product", schema="schema_mono_shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String category;
	private String productName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, updatable = false, insertable = true)
	@JsonBackReference
	private Orders orders;
	
	
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Price price;
	
	
	public void setPrice(Price price) {
		if (price == null) {
			if (this.price != null) {
				this.price.setProduct(null);
			}
		}
		else {
			price.setProduct(this);
		}
		this.price = price;
	}


	public Product(String category, String productName) {
		super();
		this.category = category;
		this.productName = productName;
	}


	public void setOrders(Orders orders2) {
		// TODO Auto-generated method stub
		orders = orders2;
	}

}
