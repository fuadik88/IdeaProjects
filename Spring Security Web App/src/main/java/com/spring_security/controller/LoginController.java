package com.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/signin")
    String formLogin(){
        return "fancy-login";
    }

    @GetMapping("/nowayin")
    String accessDenied(){
        return "accessdenied";
    }
}
