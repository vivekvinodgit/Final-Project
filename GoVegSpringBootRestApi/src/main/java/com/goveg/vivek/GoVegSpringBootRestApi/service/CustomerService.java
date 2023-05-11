package com.goveg.vivek.GoVegSpringBootRestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.CustomerBean;
import com.goveg.vivek.GoVegSpringBootRestApi.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<CustomerBean> fetchAllCustomer() {
		return customerRepository.findAll();
	}

	public void saveCustomer(CustomerBean customer) {
		customerRepository.save(customer);
		
	}
	
	

}
