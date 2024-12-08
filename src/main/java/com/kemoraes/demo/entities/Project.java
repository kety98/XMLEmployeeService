package com.kemoraes.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projects")
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project")
	private Long projectId;
	private String projectName;
	@JsonIgnore
	@OneToMany(mappedBy = "project")	
	private List<Employee> employees = new ArrayList();
	
	public Project() {
		
	}
		
	public Project(Long projectId, String projectName, List<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getProjectId() {
		return projectId;
	}	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectId, projectName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(projectId, other.projectId) && Objects.equals(projectName, other.projectName);
	}

	
	
}
