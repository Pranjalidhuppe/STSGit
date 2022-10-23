package com.spring.jpa.service;

import com.spring.jpa.entity.Employee;

import java.util.List;


public interface EmployeeService {

	public Employee getEmpById(Integer id);
	
	public List<Employee> getAllEmp();
	
	public List<Employee> getByName(String name);
	
	public List<Employee> getByCity(String city);
	
	public List<Employee> getBySalaryGreaterThan50k();
	
	public List<Employee> getBySalary(Integer salary);
	
	public void saveEmp(Employee emp);
	
	public void saveAllEmp(List<Employee> empList);
	
	//public Employee updateById(Integer id,String name);
	
	public void updateEmp(Integer id,Employee emp);
	
	public void deleteById(Integer id);
	
	public void deleteByName(String name);
	
	public void deleteAll();
}
