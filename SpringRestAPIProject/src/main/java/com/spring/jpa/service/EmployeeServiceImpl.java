package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.exception.ResourceNotFoundException;
import com.spring.jpa.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository repository;
	
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository ) {
		this.repository = repository;
	}
	
      public Employee getEmpById(Integer id) {
    	Employee employee = repository.findById(id).orElse(null);

    	  return employee;	
     }
	
	public List<Employee> getAllEmp(){
		Iterable<Employee> findAll = repository.findAll();
		
		List<Employee>empList = new ArrayList<Employee>();
		findAll.forEach(x->empList.add(x));
		
		return empList;
		
	}
	
	public void saveEmp(Employee emp) {
		repository.save(emp);
	}
	
	public void saveAllEmp(List<Employee> empList) {
		repository.saveAll(empList);
	}
	
//	public Employee updateById(Integer id,String name) {
//		Employee byId = repository.findById(id).orElse(null);
//		byId.setName(name);
//		return repository.save(byId);
//		
//	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public List<Employee> getByName(String name) {
		
		return repository.findByname(name);
	}

	@Override
	public List<Employee> getByCity(String city) {
		
		return repository.findByCity(city);
	}

	@Override
	public List<Employee> getBySalaryGreaterThan50k() {
		
		return repository.findBySalary();
	}

	@Override
	public List<Employee> getBySalary(Integer salary) {
		
		return repository.findBySalary(salary);
	}

	@Override
	public void updateEmp(Integer id, Employee emp) {
		
		Employee employee = repository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Employee not found.."));
		employee.setName(emp.getName());
		employee.setCity(emp.getCity());
		employee.setSalary(emp.getSalary());
		repository.save(employee);
		
	}

	@Override
	public void deleteByName(String name) {
		repository.deleteEmpByName(name);
		
	}


}
