package yuki.learning.demospringboot.service;

import yuki.learning.demospringboot.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long id);
}
