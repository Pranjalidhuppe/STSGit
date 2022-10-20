package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpDetails")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
	Integer id;
@Column
	String name;
@Column
	String city;

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
	return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
}

public Employee() {
	super();
}

public Employee(String name, String city) {
	super();
	this.name = name;
	this.city = city;
	
}



     


}
