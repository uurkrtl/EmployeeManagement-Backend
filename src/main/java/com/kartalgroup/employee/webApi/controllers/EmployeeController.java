package com.kartalgroup.employee.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kartalgroup.employee.business.abstracts.EmployeeService;
import com.kartalgroup.employee.business.request.EmployeeCreateRequest;
import com.kartalgroup.employee.business.request.EmployeeUpdateRequest;
import com.kartalgroup.employee.business.response.EmployeeGetByIdResponse;
import com.kartalgroup.employee.business.response.EmployeesGetAllResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	List<EmployeesGetAllResponse> getAll(){
		return this.employeeService.getAll();
	}
	
	@GetMapping("/getById")
	EmployeeGetByIdResponse getById(@RequestParam long id) {
		return this.employeeService.getById(id);
	}
	
	@PostMapping("/add")
	public boolean add(@Valid @RequestBody EmployeeCreateRequest employeeCreateRequest) {
		this.employeeService.add(employeeCreateRequest);
		return true;
	}
	
	@PutMapping("/update")
	public boolean update(@Valid @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
		this.employeeService.update(employeeUpdateRequest);
		return true;
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestParam long id) {
		this.employeeService.delete(id);
		return true;
	}
}