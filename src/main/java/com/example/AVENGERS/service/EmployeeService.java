package com.example.AVENGERS.service;

import java.util.List;

import com.example.AVENGERS.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> fetchAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployeeById(Long id, Employee employee);
	
	String deleteEmployeeById(Long id);
	
	List<Employee> getAllEmployeesBySalary(float employeeSalary);
	
	List<Employee> getAllEmployeesByEmployeeNameLength(int length);
	
	List<Employee> getAllEmployeesByEmployeeNameOddLength();
	
	List<Employee> getAllEmployeesByEmployeeNameEvenLength();
}

