package com.example.AVENGERS.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		order.setOrderTrackingNumber("2000");
		order.setStatus("PENDING");
		order.setTotalPrice(new BigDecimal(5000));
		order.setTotalQuantity(5);

		Address billingAddress = new Address("Azeemuddin nagar", "kurnool", "AP", "india", "518003");
		order.setBillingAddress(billingAddress);

		return orderRepository.save(order);
	}

	@GetMapping("/getOrders")
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/getOrder/{id}")
	public Optional<Order> getOrderById(@PathVariable("id") Long id) {
		return orderRepository.findById(id);
	}
	
	@GetMapping("/getOrderByOrderTrackingNumber/{orderTrackingNumber}")
	public List<Order> getOrderById(@PathVariable("orderTrackingNumber") String orderTrackingNumber) {
		return orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
	}
	
	

}
