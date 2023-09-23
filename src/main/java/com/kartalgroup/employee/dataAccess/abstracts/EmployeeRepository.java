package com.kartalgroup.employee.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartalgroup.employee.entities.concretes.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	boolean existsByPhone(String phone);

}
