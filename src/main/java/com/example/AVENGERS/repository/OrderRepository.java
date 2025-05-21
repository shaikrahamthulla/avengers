package com.example.AVENGERS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AVENGERS.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByOrderTrackingNumber(String orderTrackingNumber);
	List<Order> findByTotalQuantity(String totalQuantity);
}
