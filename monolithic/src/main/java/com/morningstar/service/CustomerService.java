package com.morningstar.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.morningstar.entity.Customer;
 
@Service
public interface CustomerService  {
	public Customer saveCustomer(Customer  customer);
		
	

}
