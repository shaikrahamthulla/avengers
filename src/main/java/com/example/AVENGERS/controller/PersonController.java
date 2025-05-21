package com.example.AVENGERS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AVENGERS.entity.Address;
import com.example.AVENGERS.entity.Person;
import com.example.AVENGERS.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@PostMapping("/createPerson")
	public Person createPerson() {

		List<Address> addresses = new ArrayList<Address>();
		Address address1 = new Address("Azeemuddin nagar", "kurnool", "AP", "india", "518003");
		Address address2 = new Address("VR Colony", "kurnool", "AP", "india", "518003");
		Address address3 = new Address("Ashiok nagar", "kurnool", "AP", "india", "518003");
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

		Person person = new Person("name", "7306588329", addresses);
		return personRepository.save(person);
	}

}
