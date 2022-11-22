package com.ceyentra.springboot.thymeleafdemo.service;


import com.ceyentra.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.ceyentra.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional -> removed, bcz JpaRepository provides this functionality
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // if didn't find the employee
            throw new RuntimeException("Did not found employee ID: " + id);
        }
        return theEmployee;

    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
