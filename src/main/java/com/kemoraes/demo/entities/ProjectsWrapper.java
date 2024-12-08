package com.kemoraes.demo.entities;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Projects")
public class ProjectsWrapper {
    private List<Project> Projects;

    public ProjectsWrapper() {
    }

	public ProjectsWrapper(List<Project> Projects) {
		super();
		this.Projects = Projects;
	}

	@XmlElement(name = "Project")
	public List<Project> getProjects() {
	    return Projects;
	}

}
