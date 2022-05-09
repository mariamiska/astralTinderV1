package com.astralTinderV1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public String Home()
    {
        return "index";
    }
    
    @GetMapping("/acercaDe")
    public String about()
    {
        return "about";
    }
    
    @GetMapping("/contactanos")
    public String contact()
    {
        return "contact";
    }
    
    
    
}

