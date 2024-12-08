package com.kemoraes.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemoraes.demo.entities.Project;
import com.kemoraes.demo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	public List<Project> findAll(){
		return repository.findAll();
	}
	
	public Project findById(Long id) {
		Optional<Project> obj = repository.findById(id);
		return obj.get();
	}
	
}
