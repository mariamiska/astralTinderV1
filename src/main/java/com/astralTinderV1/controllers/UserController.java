package com.astralTinderV1.controllers;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enums.Gender;
import com.astralTinderV1.enums.Province;
import com.astralTinderV1.enums.SexualOrientation;
import com.astralTinderV1.services.PhotoService;
import com.astralTinderV1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;
    private PhotoService photoServ;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/registro")
    public String mostrarFormulario(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("provinces", Province.values());
        model.addAttribute("genders",Gender.values());
        model.addAttribute("sexualOrientations",SexualOrientation.values());
        return "/user-register";
    }

    /**
     * procesa el formulario de nuevo usuario
     *
     * @param user el usuario que llega a la vista
     * @param mm devuelve una exception por thymeleaf si esta mal guardado el
     * user
     * @return si falla la validacion, al registro de nuevo. Si sale bien al
     * login TO DO! que en vez al login, muestre la carta astral primero antes
     * de salir al login que si se ingresa algun dato que este mal, no se borre
     * la info que esta bien
     *
     */
    @PostMapping("/registro")
    public String procesarFormulario(@ModelAttribute User user, ModelMap mm) {
        try {
            userService.save(user);
            return "/user-login";
        } catch (Exception e) {
            mm.addAttribute("error", e.getMessage());
            return "/user-register";
        }
    }

    /**
     * controlador qeu trabaja la url de inicio de sesion de exitoso
     *
     * return pagina perfil del usuario
     */
    @GetMapping("/perfil")
    public String showProfile(ModelMap m) {
        User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        user = userService.getUserbyEmail(userDetail.getUsername());
        m.addAttribute("user", m);
        return "user-profile";
    }

    /**
     * no tengo plantilla de este metodo todavia tiene que devolver el
     * forulacrio de edicion
     *
     * @param mm
     * @return
     */
    @GetMapping("/modificar")
    public String modifyUser(ModelMap mm) {

        return "";
    }

    /**
     * metodo limitado solo a admin,lista todos los usuarios disponibles en la
     * basede datos
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/listarTodos")
    public String listAllUsers(ModelMap mm) {
        mm.addAttribute("listaUsers", userService.getAll());
        return "user-list";
    }

}

