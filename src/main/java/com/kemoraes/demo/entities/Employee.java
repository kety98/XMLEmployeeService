package com.kemoraes.demo.entities;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	Long id;
	String name;
	String Title;
	
	public Employee() {	
	}
	
	public Employee(Long id, String name, String title) {
		super();
		this.id = id;
		this.name = name;
		Title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
