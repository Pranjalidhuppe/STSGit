package com.spring.jpa.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.spring.jpa.entity.Employee;
import com.spring.jpa.exception.ResourceNotFoundException;
import com.spring.jpa.repository.EmployeeRepository;
import com.spring.jpa.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	private static final Logger Log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/empid/{id}")
	public Employee getEmpById(Integer id) {
		Log.info("getEmpById method called");
		return service.getEmpById(id);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmp() {
		return service.getAllEmp();
	}

	@PostMapping("/save")
	public String saveEmp(@RequestBody Employee emp) {
		if(emp!=null) {
		service.saveEmp(emp);
		return "Record Added";
		}else {
			return "Record not Added please check";
		}
	}

	@GetMapping("/byname")
	public List<Employee> getByName(@RequestParam String name) {

		return service.getByName(name);
	}

	@GetMapping("/bycity")
	public List<Employee> getByCity(@RequestParam(name = "a") String city) {

		return service.getByCity(city);
	}
	@GetMapping("/50k")
	public List<Employee> getBySalaryGreaterThan50k() {

		return service.getBySalaryGreaterThan50k();
	}
	@GetMapping("/salary")
	public List<Employee> getBySalary(@RequestParam(name = "sal") Integer salary) {

		return service.getBySalary(salary);
	}
	
//	@PutMapping("/update/{id}")
//	public String updateEmployee(@PathVariable Integer id,@RequestBody Employee emp) {
//		try{                                      |
//			service.updateEmp(id, emp);           | It is giving response 200.ok whether record found or not
//			return "Employee Record Updated";     |
//		}catch(ResourceNotFoundException e) {     |Record Not Found and     Status : 200 ok
//			return "Record Not Found";            |Employee Record Updated  Status : 200 ok    
//		}
//    } TO AVOID THIS WE NEED TO DO RESPONSEENTITY AS A RETURN TYPE in response related things
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee emp) {
		try{                                      
			service.updateEmp(id, emp);           
			return ResponseEntity.ok("Record Updated");  
		}catch(ResourceNotFoundException e) {     
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());     
		}
    }
		
	
	@PatchMapping("/updateby/{id}")
	public String updateEmpSalary(@PathVariable Integer id , @RequestParam Integer salary) {
		Employee employee = repository.findById(id).get();
		employee.setSalary(salary);
		repository.save(employee);
		return "Updated....";		
	}
	
	   //@DeleteMapping("/delete") if u give like this in tomcat it will generate
       //"status": 404,"error": "Not Found"
	   //if you are trying to fetch, delete or update the data which is not present in the database then 
	   //org.springframework.dao.EmptyResultDataAccessException will occur
	
	@DeleteMapping("/{id}")                          
	public String deletebyid(@PathVariable Integer id) {
		service.deleteById(id);	
		return "Record deleted";
		
	}
	
//	@DeleteMapping("/delete")                          
//	public String deletebyname(@RequestParam(name = "name")String name) {
//		service.deleteByName(name);
//		return "Record deleted";
//		
//	}

}
