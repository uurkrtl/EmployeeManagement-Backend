package com.kartalgroup.employee.business.rules;

import org.springframework.stereotype.Service;

import com.kartalgroup.employee.core.exception.BadRequestException;
import com.kartalgroup.employee.core.exception.NotFoundException;
import com.kartalgroup.employee.dataAccess.abstracts.EmployeeRepository;
import com.kartalgroup.employee.entities.concretes.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeBusinessRules {
	private EmployeeRepository employeeRepository;
	
	public void checkIfEmployeeNull(Employee employee, long id) {
		if(employee==null) {
			throw new NotFoundException("Personal wurde nicht gefunden. Gesuchte ID: " + id);
		}
	}
	
	public void checkIfEmployeePhoneExists(String phone) {
		if(this.employeeRepository.existsByPhone(phone)) {
			throw new BadRequestException("Telefonnummer existiert bereits");
		}
	}
}