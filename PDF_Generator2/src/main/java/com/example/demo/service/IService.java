package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface IService {

		void addTeacher(Teacher teacher);
		
		public Teacher getByid(Integer id );

	public List<Teacher> getTeacherList();

	public void deleteByName(String name) ;
	
	public String updateByName (Integer id , String name );  // this is partial updATE so its PATCH
	
}	