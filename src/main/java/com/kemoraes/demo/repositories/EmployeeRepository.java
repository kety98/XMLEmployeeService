package com.kemoraes.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemoraes.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
