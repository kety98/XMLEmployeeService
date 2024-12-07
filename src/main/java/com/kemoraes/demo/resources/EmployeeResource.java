package com.kemoraes.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemoraes.demo.entities.Employee;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@GetMapping
	public ResponseEntity<Employee> findAll() {
		Employee e1 = new Employee(1L, "Nancy", "Sales Representative");
		return ResponseEntity.ok().body(e1);
	}
}
