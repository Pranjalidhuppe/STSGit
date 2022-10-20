package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Teacher;
@Repository
public interface IRepo extends JpaRepository<Teacher, Integer>{
	
	@Transactional
	@Modifying
	@Query(value ="delete from Teacher where name = :name", nativeQuery=true)
	public void deleteByName(@Param("name") String name);
    
	
}
