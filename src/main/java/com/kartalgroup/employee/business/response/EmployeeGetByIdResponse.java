package com.kartalgroup.employee.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGetByIdResponse {
	private long id;
	private String firstName;
	private String lastName;
	private String department;
	private String phone;
}