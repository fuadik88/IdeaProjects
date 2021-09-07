package com.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    String showHome() {
        return "homepage";
    }

    @GetMapping("/management")
    String manage(){
        return "management";
    }

    @GetMapping("/system")
    String accessConsole(){
        return "console";
    }
}
