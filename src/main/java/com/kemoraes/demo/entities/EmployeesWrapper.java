package com.kemoraes.demo.entities;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class EmployeesWrapper {
    private List<Employee> employees;

    public EmployeesWrapper() {
    }

	public EmployeesWrapper(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	@XmlElement(name = "employee")
	public List<Employee> getEmployees() {
	    return employees;
	}

}