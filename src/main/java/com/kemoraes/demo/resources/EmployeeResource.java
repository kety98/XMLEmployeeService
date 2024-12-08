package com.kemoraes.demo.resources;

import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemoraes.demo.entities.Employee;
import com.kemoraes.demo.entities.EmployeesWrapper;
import com.kemoraes.demo.services.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;

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
	
	@GetMapping("/export")
    public void exportToXml(HttpServletResponse response) throws Exception {
        List<Employee> employees = service.findAll();

        JAXBContext context = JAXBContext.newInstance(EmployeesWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        EmployeesWrapper wrapper = new EmployeesWrapper(employees);

        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=employees.xml");
        marshaller.marshal(wrapper, response.getOutputStream());
    }
	
}
