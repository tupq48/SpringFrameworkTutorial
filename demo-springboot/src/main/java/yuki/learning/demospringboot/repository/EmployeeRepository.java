package yuki.learning.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yuki.learning.demospringboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
