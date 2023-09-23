package com.kartalgroup.employee.business.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
	private long id;
	@Size(min = 3, message = "Der Vorname sollte mindestens 3 Zeichen lang sein")
	private String firstName;
	@Size(min = 3, message = "Der Nachname sollte mindestens 3 Zeichen lang sein")
	private String lastName;
	@Size(min = 3, message = "Die Abteilung sollte mindestens 3 Zeichen lang sein")
	private String department;
	@Size(min = 5, message = "Der Telefonnummer sollte mindestens 5 Zeichen lang sein")
	private String phone;
}