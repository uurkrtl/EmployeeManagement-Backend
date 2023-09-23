package com.kartalgroup.employee.business.abstracts;

import java.util.List;

import com.kartalgroup.employee.business.request.EmployeeCreateRequest;
import com.kartalgroup.employee.business.request.EmployeeUpdateRequest;
import com.kartalgroup.employee.business.response.EmployeeGetByIdResponse;
import com.kartalgroup.employee.business.response.EmployeesGetAllResponse;

public interface EmployeeService {
	List<EmployeesGetAllResponse> getAll();
	EmployeeGetByIdResponse getById (long id);
	public boolean add(EmployeeCreateRequest employeeCreateRequest);
	public boolean update(EmployeeUpdateRequest employeeUpdateRequest);
	public boolean delete(long id);
}