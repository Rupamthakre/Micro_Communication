package com.department.department_microservices.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.department.department_microservices.entity.Department;
import com.department.department_microservices.entity.Employee;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	 @Autowired
	 private RestTemplate restTemplate;
	 
	 private String dep = "Civil";
	 
	 @RequestMapping("/{userId}")
	 public Department deptAdd(@PathVariable("userId") String userId) {
		 Employee employee = restTemplate.getForObject("http://localhost:8050/api/employees/"+userId , Employee.class); 

		 return new Department(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),dep);		 
	 }
	 
	@RequestMapping("/api")			 
	public Employee check(){	
		 Employee employee = restTemplate.getForObject("http://localhost:8050/api/employees/1" , Employee.class);   
		 
		   return new Employee(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
	 }
	 
	 
	 
}
