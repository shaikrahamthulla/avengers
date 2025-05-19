package com.example.AVENGERS.controller;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AVENGERS.entity.Address;
import com.example.AVENGERS.entity.Order;
import com.example.AVENGERS.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping("/createOrder")
	public Order createOrder() {
		Order order = new Order();
		order.setOrderTrackingNumber("1000");
		order.setStatus("COMPLETED");
		order.setTotalPrice(new BigDecimal(2000));
		order.setTotalQuantity(5);
		
		Address billingAddress = new Address("Azeemuddin nagar", "kurnool","AP","india","518003");
		order.setBillingAddress(billingAddress);
		
		return orderRepository.save(order);
	}

}
