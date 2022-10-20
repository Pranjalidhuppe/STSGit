package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.IRepo;
import com.example.demo.entity.Teacher;
import com.example.demo.service.IService;
import com.example.demo.service.PdfGenerator;


@RestController
@RequestMapping("/teacher")

public class Tcontroller {

	@Autowired
	private IService serviceimpl;

	@GetMapping("/{id}")
	public Teacher getbyId(@PathVariable Integer id) {
		return serviceimpl.getByid(id);
	}

	@PostMapping("/save")
	public String addTeacher(@RequestBody Teacher teacher) {
		serviceimpl.addTeacher(teacher);
		return "Record Saved";
	}

	@DeleteMapping("/deletename")
	public void deleteByName(@RequestParam String name) {
		serviceimpl.deleteByName(name);
	}

	@PatchMapping("/updatename/{id}")
	public String updateByName(@PathVariable Integer id, @RequestParam String name) {
		return serviceimpl.updateByName(id, name);
	}

	@GetMapping("/export/pdf")
	public void exportToPdf(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

		String string = df.format(new Date());

		String headerKey = "Content-Disposition";

		String headerValue = "attachment; filename=teacher" + string + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Teacher> list = serviceimpl.getTeacherList();
		PdfGenerator pg = new PdfGenerator(list);

		pg.exportpdf(list,response);
		

	}

}
