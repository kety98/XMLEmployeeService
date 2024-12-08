package com.kemoraes.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemoraes.demo.entities.Employee;
import com.kemoraes.demo.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
