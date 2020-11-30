package com.morningstar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Customer", schema="schema_mono_shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="customer_name")
	private String name;
	
	private String mobileNumber;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	private List<Orders> orderList = new ArrayList<Orders>();
	
	
	
	
	
	
	public void addOrder(Orders order) {
		orderList.add(order);
		order.setCustomer(this);
	}






	public Customer(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
	
}
