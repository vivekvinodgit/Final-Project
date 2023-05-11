package com.goveg.vivek.GoVegSpringBootRestApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.CustomerBean;
import com.goveg.vivek.GoVegSpringBootRestApi.service.CustomerService;
import com.goveg.vivek.GoVegSpringBootRestApi.service.ItemService;

@RestController
@RequestMapping(path="customer")
public class CustomerController {
	
	private CustomerService customerService;
	private ItemService itemService;
	
	public CustomerController(CustomerService customerService, ItemService itemService) {
        this.customerService=customerService;
        this.itemService=itemService;
    }
	
	@GetMapping
	public List<CustomerBean> getAllCustomer() {
		return customerService.fetchAllCustomer();
	}
	
	@PostMapping
	public void addFarmer(@RequestBody CustomerBean customer){
		
		float price= itemService.findItempriceByItemId(customer.getItemId());
		price = customer.getQuantity()*price +(((price*5)/100)*customer.getQuantity());
		System.out.println("Price is "+price);
		
		customer.setPrice(price);
		customerService.saveCustomer(customer);
	}
	

}
