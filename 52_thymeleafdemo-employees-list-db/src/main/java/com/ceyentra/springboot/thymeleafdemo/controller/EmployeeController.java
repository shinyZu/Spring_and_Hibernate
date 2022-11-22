package com.ceyentra.springboot.thymeleafdemo.controller;

import com.ceyentra.springboot.thymeleafdemo.entity.Employee;
import com.ceyentra.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get the employees from the db
        List<Employee> theEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
