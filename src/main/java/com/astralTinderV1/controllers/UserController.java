package com.astralTinderV1.controllers;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enums.Gender;
import com.astralTinderV1.enums.Province;
import com.astralTinderV1.enums.SexualOrientation;
import com.astralTinderV1.services.PhotoService;
import com.astralTinderV1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;
    private PhotoService photoServ;

    @Autowired
    public UserController(UserService userService, PhotoService photoServ) {
        this.userService = userService;
        this.photoServ = photoServ;
    }

    @GetMapping("/registro")
    public String mostrarFormulario(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("provinces", Province.values());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("sexualOrientations", SexualOrientation.values());

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
    public String procesarFormulario(@ModelAttribute User user, ModelMap mm,
            @RequestParam(required = false) MultipartFile archivo) {
        try {
            userService.save(user, archivo);
            return "/user-login";
        } catch (Exception e) {
            mm.addAttribute("error", e.getMessage());
            e.printStackTrace();
            return "redirect:/registro";
        }
    }

//    @GetMapping("/registro/foto")
//    public String mostrarFormularioFoto(ModelMap model) {
//        model.addAttribute("photo", new Photo());
//        return "/user-photo-register";
//    }
//
//    @PostMapping("/registro/foto")
//    public String procesarFormularioFoto(@ModelAttribute Photo photo, @ModelAttribute User user, ModelMap mm,
//            @RequestParam MultipartFile archivo) {
//        try {
//            photoServ.multiPartToEntity(archivo);
////            user.setImage(photo);
////            userService.save(user);
//            return "/user-login";
//        } catch (Exception e) {
//            mm.addAttribute("error", e.getMessage());
//            return "/user-photo-register";
//        }
//    }
    /**
     * controlador qeu trabaja la url de inicio de sesion de exitoso
     *
     * return pagina perfil del usuario
     */
//    @GetMapping("/perfil")
//    public String showProfile(ModelMap m) {
//        User user;
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail = (UserDetails) auth.getPrincipal();
//        user = userService.getUserbyEmail(userDetail.getUsername());
//        m.addAttribute("user", m);
//        return "user-profile";
//    }

 @GetMapping("/perfil/{id}")
    public String showProfile(ModelMap m,@PathVariable String id)
    {
        User user;
        try
        {
            user=userService.findById(id);
            m.addAttribute("user", user);
            return "user-profile";            
        }catch(Exception e)
        {
            System.out.println("no se encontro el usurio con esa id");
            return "redirect:/";
        }
    }


    /**
     * no tengo plantilla de este metodo todavia tiene que devolver el
     * forulacrio de edicion
     *
     * @param mm
     * @return
     */
    @GetMapping("/modificar/{id}")
    public String modify(ModelMap model, @PathVariable String id) {
        try {
            model.addAttribute("user", userService.findById(id));
            model.addAttribute("provinces", Province.values());
            model.addAttribute("genders", Gender.values());
            model.addAttribute("sexualOrientations", SexualOrientation.values());

            return "/user-profile-modify";
        } catch (Exception e) {
            return "redirect:/user-profile";
        }
    }

    @PostMapping("/modificar")
    public String modifyUser(@ModelAttribute User user, ModelMap mm,
            @RequestParam(required = false) MultipartFile archivo) {
        try {
            userService.modifyUser(user, archivo);
            return "redirect:/ruleta";
        } catch (Exception e) {
            mm.addAttribute("error", e.getMessage());
            e.printStackTrace();
            return "redirect:/modificar";
        }
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
