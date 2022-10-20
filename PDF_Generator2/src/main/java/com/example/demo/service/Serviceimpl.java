package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IRepo;
import com.example.demo.entity.Teacher;
@Service
public class Serviceimpl implements IService{
	
	@Autowired
	private IRepo irepo;
	
	public Serviceimpl(IRepo irepo) {
		this.irepo = irepo;
	}
	
	@Override
	public List<Teacher> getTeacherList() {
		
		return irepo.findAll();
	}

	@Override
	public void deleteByName(String name) {
		irepo.deleteByName(name);
	}

	@Override
	public String updateByName(Integer id, String name) {
		Teacher findById = irepo.findById(id).get();
		findById.setName(name);
		irepo.save(findById);
		return "record updated";
	}

	@Override
	public void addTeacher(Teacher teacher) {
		irepo.save(teacher);
	}


	@Override
	public Teacher getByid(Integer id ) {
		
		 Teacher byId = irepo.findById(id).orElse(null);
		 return byId;
	}

	

}
	

