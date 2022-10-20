package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.service.EmployeeServiceImpl;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		EmployeeServiceImpl bean = context.getBean(EmployeeServiceImpl.class);
		
		Employee emp = new Employee("Pranjali", "Mumbai" );
		
		bean.saveEmp(emp);
	}

}
