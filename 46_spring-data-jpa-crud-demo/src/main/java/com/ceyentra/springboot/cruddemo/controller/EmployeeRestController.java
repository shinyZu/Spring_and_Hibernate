package com.ceyentra.springboot.cruddemo.controller;

import com.ceyentra.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject employee dao
    @Autowired
    private EmployeeService employeeService;

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw  new RuntimeException("Employee ID Not Found : " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item .. instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw  new RuntimeException("Employee ID Not Found : " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee - " + employeeId;
    }
}
