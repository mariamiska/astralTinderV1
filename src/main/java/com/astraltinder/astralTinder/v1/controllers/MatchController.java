package com.astraltinder.astralTinder.v1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ruleta")
public class MatchController {

    private VoteService voteService;
    private ChooseYourPartnerService cypS;
    private UserService userService;

    @Autowired
    public MatchController(VoteService voteService, ChooseYourPartnerService cypS, UserService userService) {
        this.voteService = voteService;
        this.cypS = cypS;
        this.userService = userService;
    }

    @GetMapping
    public String ruleta(ModelMap model) {

        model.addAttribute("user", cypS.randomUser());
        model.addAttribute("vote", new Vote());
        return "index/6ruletamuestrayacciones";

    }

//    @PostMapping
//    public String vistaRuelta(){
//        
//        return null;
//        
//    }
//    @GetMapping("/like")
//    public String addLike(@ModelAttribute Vote vote, ModelMap model){
//        
//        return "index/6ruletamuestrayacciones";
//        
//    }
}
