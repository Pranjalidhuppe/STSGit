package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository repository;
	
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
	
	public void updateById(Integer id,String name) {
		Employee byId = repository.findById(id).orElse(null);
		byId.setName(name);
		repository.save(byId);
		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

}
