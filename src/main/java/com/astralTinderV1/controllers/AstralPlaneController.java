package com.astralTinderV1.controllers;

import com.astralTinderV1.services.AstralPlaneService;
import com.astralTinderV1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
