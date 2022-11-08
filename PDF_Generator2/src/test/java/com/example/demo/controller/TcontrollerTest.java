package com.example.demo.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Repository.IRepo;
import com.example.demo.entity.Teacher;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TcontrollerTest {
	

	@Autowired
	private IRepo repository;

	@Autowired
	private Tcontroller controller;

	private RequestSpecification requestSpecification;
	@LocalServerPort
	private int port;

	@PostConstruct
	public void initRequestSpecification() {
		final RequestSpecBuilder tempSpec = new RequestSpecBuilder();
		requestSpecification = tempSpec.setBaseUri("http://localhost:" + port + "/emp").setContentType(ContentType.JSON)
				.build();

	}

	@Before
	public void init() {
		repository.deleteAll();
	}
	
	@Test
	public void testGetbyId() {
		//Given
		Teacher teacher = new Teacher();
		teacher.setName("Pranjali");
		teacher.setSalary(55000);
		teacher.setDepartment("IT");
		
		Teacher teacher2 = repository.save(teacher);
		
		//When
		ResponseEntity<Teacher> id = controller.getbyId(teacher2.getId());
		
       //Then
		assertEquals(HttpStatus.OK.value(), id.getStatusCodeValue());
		
	}
	
	@Test
	public void testGetbyIdExpect404() {
		//Given
				Teacher teacher = new Teacher();
				teacher.setName("Pranjali");
				teacher.setSalary(55000);
				teacher.setDepartment("IT");
				
				Teacher teacher2 = repository.save(teacher);
				
	   //When
				ResponseEntity<Teacher> id = controller.getbyId(teacher2.getId());
				
	   //Then
				assertEquals(HttpStatus.NOT_FOUND.value(), id.getStatusCodeValue());
	}
	
	@Test
	public void testaddTeacher() {
		
		Teacher teacher = new Teacher();
		teacher.setName("Pranjali");
		teacher.setSalary(55000);
		teacher.setDepartment("IT");
	
		Teacher teacher2 = repository.save(teacher);

		ArrayList<Teacher> list = new ArrayList<Teacher>();
		list.add(teacher2);
		
		assertFalse(list.isEmpty());		
		
	}
	
	@Test
	public void testDeleteByName() {
		//given
		Teacher teacher = new Teacher();
		teacher.setName("Pranjali");
		teacher.setSalary(55000);
		teacher.setDepartment("IT");
		
		Teacher tea = repository.save(teacher);
        //when
		controller.deleteByName("Pranjali");

		ResponseEntity<Teacher> id = controller.getbyId(tea.getId());
		//then
		assertEquals(HttpStatus.NOT_FOUND.value(), id.getStatusCodeValue());
		
	}
	@Test
	public void testUpdateByName() {
		
		//given
		Teacher teacher = new Teacher();
		teacher.setName("Pranjali");
		teacher.setSalary(55000);
		teacher.setDepartment("IT");
		Teacher tea = repository.save(teacher);
		//when
		controller.updateByName(tea.getId(), "Anjali");
		
		ResponseEntity<Teacher> id = controller.getbyId(tea.getId());
		
		//then
		assertNotSame(tea,id);
		
	}
	

}
