package com.kemoraes.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemoraes.demo.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
