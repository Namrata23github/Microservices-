package com.morningstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morningstar.entity.Customer;
import com.morningstar.repository.CustomerRepository;
import com.morningstar.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
return customerRepository.save(customer);
}

}
