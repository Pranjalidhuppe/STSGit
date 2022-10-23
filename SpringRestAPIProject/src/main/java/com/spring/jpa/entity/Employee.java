package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpDetails1")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
	Integer id;
@Column
	String name;
@Column
	String city;
@Column
Integer salary;

public Integer getSalary() {
	return salary;
}

public void setSalary(Integer salary) {
	this.salary = salary;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
}

public Employee() {
	super();
}

public Employee(String name, String city, Integer salary) {
	super();
	this.name = name;
	this.city = city;
	this.salary = salary;
}





     


}
