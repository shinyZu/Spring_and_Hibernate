package com.ceyentra.springdemo.mvc.controller;

import com.ceyentra.springdemo.mvc.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our com.ceyentra.springdemo.mvc.validation
    /** this method will be called for every web request coming into the Controller*/
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        // create a customer object
        Customer theCustomer = new Customer();

        //add customer object to the model
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){
        // log the input data
        System.out.println("last name: |" + theCustomer.getLastName() + "|");
       /* System.out.println("Binding result: " + theBindingResult);
        System.out.println("\n\n\n\n");*/

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
