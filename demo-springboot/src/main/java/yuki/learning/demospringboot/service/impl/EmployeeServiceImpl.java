package yuki.learning.demospringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yuki.learning.demospringboot.dto.EmployeeDto;
import yuki.learning.demospringboot.entity.Employee;
import yuki.learning.demospringboot.exception.ResourceNotFoundException;
import yuki.learning.demospringboot.mapper.EmployeeMapper;
import yuki.learning.demospringboot.repository.EmployeeRepository;
import yuki.learning.demospringboot.service.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
							.orElseThrow(() -> 
								new ResourceNotFoundException("Not exist employee with id " + employeeId));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
}
