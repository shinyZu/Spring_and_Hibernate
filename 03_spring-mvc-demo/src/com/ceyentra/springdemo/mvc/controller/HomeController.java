package com.ceyentra.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // says this is a mvc controller - extends @Component
public class HomeController {

    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }
//    public String showPage(){
//        return "teststaticfile";
//    }
}
