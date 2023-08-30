package yuki.learning.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yuki.learning.demospringboot.dto.EmployeeDto;
import yuki.learning.demospringboot.mapper.EmployeeMapper;
import yuki.learning.demospringboot.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping(value = "/demo")
	public String demo() {
		return "hello";
	}
}
