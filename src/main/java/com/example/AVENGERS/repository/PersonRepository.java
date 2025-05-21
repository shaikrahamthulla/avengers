package com.example.AVENGERS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AVENGERS.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
