package com.example.AVENGERS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AVENGERS.entity.Employee;
import com.example.AVENGERS.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	private Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeService.fetchAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		System.out.println(id);
		return employeeService.getEmployeeById(id);
	}

	// @PutMapping("/employee/{id}")
	// public Employee updateEmployee(@PathVariable("id") Long id,
	// @RequestBody Employee employee) {
	// return employeeService.updateEmployeeById(id, employee);
	// }

	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id,	@RequestBody Employee employee) {

		return employeeService.updateEmployeeById(id, employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		return employeeService.deleteEmployeeById(id);

	}
	
	@GetMapping("/employeesBySalary/{salary}")
	public List<Employee> getAllEmployeesBySalary(@PathVariable("salary") float employeeSalary) {
		return employeeService.getAllEmployeesBySalary(employeeSalary);
	}
	
	@GetMapping("/employeesByEmployeeNameLength/{id}")
	public List<Employee> getAllEmployeesByEmployeeNameLength(@PathVariable("id") int length) {
		return employeeService.getAllEmployeesByEmployeeNameLength(length);
	}
	
	@GetMapping("/employeesByEmployeeNameOddLength")
	public List<Employee> getAllEmployeesByEmployeeNameOddLength() {
		return employeeService.getAllEmployeesByEmployeeNameOddLength();
	}

}
