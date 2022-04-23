package com.astralTinderV1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/perfilAstral")
public class AstralPlaneController {
     AstralPlaneService apServ;
     UserService uS;

        @Autowired
    public AstralPlaneController(AstralPlaneService apServ) {
        this.apServ = apServ;
    }
              @GetMapping("/mostrar")
    public String ModifyUser(ModelMap mm) {

        return "";
    }

}
