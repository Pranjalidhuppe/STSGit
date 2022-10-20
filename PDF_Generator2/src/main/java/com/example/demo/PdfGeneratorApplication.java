package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.IRepo;
import com.example.demo.entity.Teacher;
import com.example.demo.service.IService;
  
@SpringBootApplication
public class PdfGeneratorApplication implements CommandLineRunner{

	@Autowired
	  private IService service;
	  
	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
	
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	
	}
}
