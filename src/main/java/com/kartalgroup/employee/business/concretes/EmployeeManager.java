package com.kartalgroup.employee.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartalgroup.employee.business.abstracts.EmployeeService;
import com.kartalgroup.employee.business.request.EmployeeCreateRequest;
import com.kartalgroup.employee.business.request.EmployeeUpdateRequest;
import com.kartalgroup.employee.business.response.EmployeeGetByIdResponse;
import com.kartalgroup.employee.business.response.EmployeesGetAllResponse;
import com.kartalgroup.employee.business.rules.EmployeeBusinessRules;
import com.kartalgroup.employee.core.utilities.mappers.ModelMapperService;
import com.kartalgroup.employee.dataAccess.abstracts.EmployeeRepository;
import com.kartalgroup.employee.entities.concretes.Employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeManager implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapperService modelMapperService;
	@Autowired
	private EmployeeBusinessRules employeeBusinessRules;

	@Override
	public List<EmployeesGetAllResponse> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		List<EmployeesGetAllResponse> employeesGetAllResponses = employees.stream().map(empolyee->this.modelMapperService.forResponse().map(empolyee, EmployeesGetAllResponse.class)).collect(Collectors.toList());
		return employeesGetAllResponses;
	}

	@Override
	public EmployeeGetByIdResponse getById(long id) {
		Employee employee = this.employeeRepository.findById(id).orElse(null);
		employeeBusinessRules.checkIfEmployeeNull(employee, id);
		EmployeeGetByIdResponse employeeGetByIdResponse = this.modelMapperService.forResponse().map(employee, EmployeeGetByIdResponse.class);
		return employeeGetByIdResponse;
	}

	@Override
	public boolean add(EmployeeCreateRequest employeeCreateRequest) {
		this.employeeBusinessRules.checkIfEmployeePhoneExists(employeeCreateRequest.getPhone());
		Employee employee = this.modelMapperService.forRequest().map(employeeCreateRequest, Employee.class);
		this.employeeRepository.save(employee);
		return true;
	}

	@Override
	public boolean update(EmployeeUpdateRequest employeeUpdateRequest) {
		Employee employee = this.modelMapperService.forRequest().map(employeeUpdateRequest, Employee.class);
		this.employeeRepository.save(employee);
		return true;
	}

	@Override
	public boolean delete(long id) {
		this.employeeRepository.deleteById(id);
		return true;
	}
}