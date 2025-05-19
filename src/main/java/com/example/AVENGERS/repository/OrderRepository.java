package com.example.AVENGERS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AVENGERS.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Order findByOrderTrackingNumber(String orderTrackingNumber);
}
