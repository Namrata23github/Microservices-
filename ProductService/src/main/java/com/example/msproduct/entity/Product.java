package com.example.msproduct.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name ="Product", schema ="schema_shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String category;
	public Product(String category, String model, String name, String status) {
		super();
		this.category = category;
		this.model = model;
		this.name = name;
		this.status = status;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	private String model;
	private String name;
	private String status;
}
