package com.gvalmana.client.events.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.gvalmana.client.customers.domain.entity.Customer;
import com.gvalmana.client.events.models.CustomerCreatedEvent;
import com.gvalmana.client.events.models.Event;
import com.gvalmana.client.events.models.EventTypes;

@Component
public class CustomerEventsService {

	@Autowired
	private KafkaTemplate<String, Event<?>> eventProducer;
	
	@Value("${topic.customer.name:customers}")
	private String topicCustomer;
	
	public void publish(Customer entity) {
		CustomerCreatedEvent event = new CustomerCreatedEvent();
		event.setData(entity);
		event.setDate(new Date());
		event.setType(EventTypes.CREATED);
		event.setId(UUID.randomUUID().toString());		
		this.eventProducer.send(topicCustomer, event);
	}
}
