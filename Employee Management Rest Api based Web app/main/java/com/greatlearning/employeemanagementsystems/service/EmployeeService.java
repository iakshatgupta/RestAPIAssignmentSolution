package com.greatlearning.employeemanagementsystems.service;

import java.util.List;
import com.greatlearning.employeemanagementsystems.entity.Employee;
import com.greatlearning.employeemanagementsystems.entity.Role;
import com.greatlearning.employeemanagementsystems.entity.User;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	public List<Employee> searchByFirstName(String firstName);
	
	public List<Employee> sortByFirstName(String order);
	
	public User saveUser(User user);
	
	public Role saveRole(Role role);
	
	public Employee findEmployeeById(int theId);

}