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

import com.kemoraes.demo.entities.Project;
import com.kemoraes.demo.services.ProjectService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {
	
	@Autowired
	private ProjectService service;
	
	@GetMapping
	public ResponseEntity<List<Project>> findAll() {
		List<Project> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> findById(@PathVariable Long id){
		Project obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@GetMapping("/export")
//    public void exportToXml(HttpServletResponse response) throws Exception {
//        List<Project> Projects = service.findAll();
//
//        JAXBContext context = JAXBContext.newInstance(ProjectsWrapper.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        ProjectsWrapper wrapper = new ProjectsWrapper(Projects);
//
//        response.setContentType("application/xml");
//        response.setHeader("Content-Disposition", "attachment; filename=Projects.xml");
//        marshaller.marshal(wrapper, response.getOutputStream());
//    }
	
}
