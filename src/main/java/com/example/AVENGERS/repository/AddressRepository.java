package com.example.AVENGERS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AVENGERS.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
