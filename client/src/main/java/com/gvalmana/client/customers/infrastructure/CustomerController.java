package com.gvalmana.client.customers.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvalmana.client.customers.application.ICustomerService;
import com.gvalmana.client.customers.domain.entity.Customer;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@PostMapping
	public Customer save(@RequestBody Customer entity) {
		return this.service.register(entity);
	}
}
