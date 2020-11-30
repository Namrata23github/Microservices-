package com.morningstar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders", schema="schema_mono_shopping")
@Data @NoArgsConstructor @AllArgsConstructor
public class Orders {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String orderName;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false, insertable = true)
	@JsonBackReference
	private Customer customer;


	@JsonManagedReference  
	@OneToMany(mappedBy="orders", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	private List<Product> productList = new ArrayList<>();


	public void addProduct(Product prod) {
		productList.add(prod);
		prod.setOrders(this);
	}

	public void removeProduct(Product prod) {
		productList.remove(prod);
		prod.setOrders(null);
	}

	public void setOrderName(String string) {
		// TODO Auto-generated method stub
		orderName = string;
	}

	public void setProductList(List<Product> productList2) {
		// TODO Auto-generated method stub
		productList = productList2;
	}

	public void setCustomer(Customer customer2) {
		// TODO Auto-generated method stub
		customer = customer2;
	}

}
