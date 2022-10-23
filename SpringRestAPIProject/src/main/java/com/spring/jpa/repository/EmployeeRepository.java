package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
    public List<Employee> findByname(String name);
	
	public List<Employee> findByCity(String city);
	
	
	//Native query = table name & column name
	//hql query = Entity Class name & variables 
	
	@Query(value = "select * from emp_details1 where salary >= 50000",nativeQuery = true)
	public List<Employee> findBySalary();
	
	@Query(value = "select * from emp_details1 where salary >= :salary",nativeQuery = true)
	public List<Employee> findBySalary(@Param("salary") Integer salary);
	 
	@Transactional
	@Modifying
	@Query("delete From Employee where name = :name")
	public void deleteEmpByName(String name);
}
