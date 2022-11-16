package com.ceyentra.springdemo.controller;

import com.ceyentra.springdemo.dao.CustomerDAO;
import com.ceyentra.springdemo.entity.Customer;
import com.ceyentra.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel){

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);

        // add the customers to the model
        return "list-customers";
    }

    @GetMapping("/showForForAdd")
    public String showFormForAdd(Model theModel) {

        // create a new model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    // public String saveCustomer (Model theModel, Customer theCustomer){
    public String saveCustomer (@ModelAttribute("customer") Customer theCustomer){
        // theModel.addAttribute("customer", theCustomer);

        // save the customer using the service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showForForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // get the customer from the database
         Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a model attribute to pre-populate the form
         theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        customerService.deleteCustomer(theId);
        // send over to our form
        return "redirect:/customer/list";
    }

}
