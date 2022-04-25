/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astralTinderV1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sebag
 */
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

