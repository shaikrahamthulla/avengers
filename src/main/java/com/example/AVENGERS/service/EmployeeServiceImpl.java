package com.example.AVENGERS.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AVENGERS.entity.Employee;
import com.example.AVENGERS.repository.EmployeeRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();	
		return allEmployees;
	}
	@Override
	public Employee getEmployeeById(Long id) {

		System.out.println(id);
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}

		return null;
	}
	// @Override
	// public Employee updateEmployeeById(Long id, Employee employee) {
	// Optional<Employee> employee1 = employeeRepository.findById(id);
	//
	// if (employee1.isPresent()) {
	// Employee originalEmployee = employee1.get();
	//
	// if (Objects.nonNull(employee.getEmployeeName())) {
	//
	// originalEmployee.setEmployeeName(employee.getEmployeeName());
	// }
	// if (Objects.nonNull(employee.getEmployeeSalary()) &&
	// employee.getEmployeeSalary() != 0) {
	//
	// originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
	//
	// }
	// return employeeRepository.save(originalEmployee);
	// }
	// return null;
	//
	// }

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {

		Optional<Employee> employee1 = employeeRepository.findById(id);

		if (employee1.isPresent()) {
			Employee originalEmployee = employee1.get();

			if (Objects.nonNull(employee.getEmployeeName())) {

				originalEmployee.setEmployeeName(employee.getEmployeeName());
			}

			if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {

				originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
			}
			return employeeRepository.save(originalEmployee);
		}
		return null;
	}

	@Override
	public String deleteEmployeeById(Long id) {

		if (employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		return "No such employee in the datebase";

	}
	
	@Override
	public List<Employee> getAllEmployeesBySalary(float employeeSalary) {
		List<Employee> allEmployees = employeeRepository.findAll();

		List<Employee> listEmployees = allEmployees.stream().filter(e -> e.getEmployeeSalary() >= employeeSalary).collect(Collectors.toList());
	
		return listEmployees;
	}
	
	@Override
	public List<Employee> getAllEmployeesByEmployeeNameLength(int length) {
		List<Employee> allEmployees = employeeRepository.findAll();

		List<Employee> listEmployees1 = allEmployees.stream().filter(e -> e.getEmployeeName().length() == length).collect(Collectors.toList());
	
		return listEmployees1;
	}
	
	
	public List<Employee> getAllEmployeesByEmployeeNameOddLength() {
		List<Employee> allEmployees = employeeRepository.findAll();

		List<Employee> listEmployees1 = allEmployees.stream().filter(e -> e.getEmployeeName().length()  % 2 != 0).collect(Collectors.toList());
	
		return listEmployees1;
	}
	
	public List<Employee> getAllEmployeesByEmployeeNameEvenLength() {
		List<Employee> allEmployees = employeeRepository.findAll();
		List<Employee> listEmployees1 = allEmployees.stream().filter(e -> e.getEmployeeName().length()  % 2 == 0).collect(Collectors.toList());	
		return listEmployees1;
	}
	
	public List<String> getAllEmployeeNames() {
		List<Employee> allEmployees = employeeRepository.findAll();
		List<String> listEmployees1 = allEmployees.stream().map(e -> e.getEmployeeName()).collect(Collectors.toList());	
		return listEmployees1;
	}
}
