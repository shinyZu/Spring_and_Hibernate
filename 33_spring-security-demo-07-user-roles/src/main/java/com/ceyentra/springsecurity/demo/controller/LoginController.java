package com.ceyentra.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
//        return "plain-login";
        return "fancy-login";
    }

    // add a request mapping for custom access denied page
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
