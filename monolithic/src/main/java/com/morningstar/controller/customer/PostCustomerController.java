package com.morningstar.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morningstar.entity.Customer;
import com.morningstar.entity.Orders;
import com.morningstar.entity.Price;
import com.morningstar.service.CustomerService;
import com.morningstar.entity.Product;



@RestController
public class PostCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/api/v1.0/save/customer")
	public ResponseEntity<Customer> saveCustomer(){
		Customer customer = buildCustomer();
		
		Customer cust = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	private  Customer buildCustomer() {
		Customer customer = new Customer("namrata", "999999999");
		Orders orders = new Orders();
		orders.setOrderName("orderOne");
		List<Product> productList = builProductList();
		orders.setProductList(productList);
		customer.addOrder(orders);
		return customer;
		
	}

	private List<Product> builProductList() {
		// TODO Auto-generated method stub
		Product product1 = new Product("CategoryOne", "PorductOne");
		product1.setPrice(new Price(100D,20D));
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(product1);
		
		Product product2 = new Product("CategoryTwo", "PorductTwo");
		product1.setPrice(new Price(1000D,20D));
		prodList.add(product2);

		return prodList;
		
		
	}

}
