package com.kartalgroup.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kartalgroup.employee.business.abstracts.EmployeeService;
import com.kartalgroup.employee.business.request.EmployeeCreateRequest;
import com.kartalgroup.employee.business.request.EmployeeUpdateRequest;
import com.kartalgroup.employee.business.response.EmployeeGetByIdResponse;
import com.kartalgroup.employee.business.response.EmployeesGetAllResponse;

@SpringBootTest
public class EmployeeServiceTest {
	EmployeeService mockEmployeeService;
	
	@Test
	public void testGetAllEmployee() {
		
		//arrange
		mockEmployeeService = mock(EmployeeService.class);
		
		List<EmployeesGetAllResponse> fakeEmployees = List.of(
				new EmployeesGetAllResponse(100L, "ugur", "kartal", "software", "2323213"),
				new EmployeesGetAllResponse(101L, "yusuf", "kartal", "software", "2323213"),
				new EmployeesGetAllResponse(102L, "seyma", "kartal", "software", "2323213")
				);
		
		when(mockEmployeeService.getAll()).thenReturn(fakeEmployees);
		
		//act
		List<EmployeesGetAllResponse> actualEmployees = mockEmployeeService.getAll();
		
		//assert
		assertEquals(fakeEmployees, actualEmployees);
	}
	
	@Test
	public void testGetByIdEmployee() {
		
		//arrange
		mockEmployeeService = mock(EmployeeService.class);
		
		EmployeeGetByIdResponse fakeEmployee = new EmployeeGetByIdResponse(100L, "ugur", "kartal", "software", "2323213");		
		when(mockEmployeeService.getById(100L)).thenReturn(fakeEmployee);
		
		//act
		EmployeeGetByIdResponse actualEmployee = mockEmployeeService.getById(100L);
		
		//assert
		assertEquals(fakeEmployee, actualEmployee);
	}
	
	@Test
	public void testAddEmployee() {
		
		//arrange
		mockEmployeeService = mock(EmployeeService.class);
		
		EmployeeCreateRequest fakeEmployee = new EmployeeCreateRequest("ugur", "kartal", "software", "2323213");		
		when(mockEmployeeService.add(fakeEmployee)).thenReturn(true);
		
		//act
		boolean result = mockEmployeeService.add(fakeEmployee);
		
		//assert
		assertTrue(result);
	}
	
	@Test
	public void testUpdateEmployee() {
		
		//arrange
		mockEmployeeService = mock(EmployeeService.class);
		
		EmployeeUpdateRequest fakeEmployee = new EmployeeUpdateRequest(100L, "ugur", "kartal", "software", "2323213");		
		when(mockEmployeeService.update(fakeEmployee)).thenReturn(true);
		
		//act
		boolean result = mockEmployeeService.update(fakeEmployee);
		
		//assert
		assertTrue(result);
	}
	
	@Test
	public void testDeleteEmployee() {
		
		//arrange
		mockEmployeeService = mock(EmployeeService.class);
		
		long fakeId = 100L;		
		when(mockEmployeeService.delete(fakeId)).thenReturn(true);
		
		//act
		boolean result = mockEmployeeService.delete(fakeId);
		
		//assert
		assertTrue(result);
	}
}