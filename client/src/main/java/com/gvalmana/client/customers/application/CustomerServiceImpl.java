package com.gvalmana.client.customers.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvalmana.client.customers.domain.entity.Customer;
import com.gvalmana.client.events.services.CustomerEventsService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private final CustomerEventsService customerEvent;
	
	public CustomerServiceImpl() {
		super();
		this.customerEvent = new CustomerEventsService();
	}
	
	@Override
	public Customer register(Customer entity) {
		
		Customer res = this.customerRepository.save(entity);
		if (res != null) {
			this.customerEvent.publish(res);			 
		}
		return res;
	}

}
