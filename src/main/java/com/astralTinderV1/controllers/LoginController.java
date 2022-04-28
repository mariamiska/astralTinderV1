package com.astralTinderV1.controllers;

import com.astralTinderV1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//tener en cuenta que los directorios de las plantillas pueden cambiar a medida que el front meta 
@Controller
@RequestMapping("/login")
public class LoginController {

    UserService uS;

    @Autowired
    public LoginController(UserService uS) {
        this.uS = uS;
    }

    /**
     * envia la pagina de registro al usuario no se necesita un post
     *
     * @param error no me queda claro bien de donde sale este error spring
     * security parece que lo envia a la vista cuando no se ingresa
     * correctamente el user
     * @param model envia el error a la vista
     * @return pagina de inicio de sesion
     */
    @GetMapping()
    public String Login(@RequestParam(required = false) String error, ModelMap model) {
        if (error != null) {
            model.put("error", "email o password invalidos");
        }
        return "user-login";
    }

    @GetMapping("/logout")
    public String logOut() {
        return "user-login";
    }
}
