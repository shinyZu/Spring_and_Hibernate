package com.ceyentra.springboot.thymeleafdemo.dao;


import com.ceyentra.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
