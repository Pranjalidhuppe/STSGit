package com.spring.jpa.service;

import com.spring.jpa.entity.Employee;

import java.util.List;


public interface EmployeeService {

	public Employee getEmpById(Integer id);
	
	public List<Employee> getAllEmp();
	
	public void saveEmp(Employee emp);
	
	public void saveAllEmp(List<Employee> empList);
	
	public void updateById(Integer id,String name);
	
	public void deleteById(Integer id);
	
	public void deleteAll();
}
