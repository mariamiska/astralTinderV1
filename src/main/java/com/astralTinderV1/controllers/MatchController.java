package com.astralTinderV1.controllers;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enttities.Vote;
import com.astralTinderV1.services.ChooseYourPartnerService;
import com.astralTinderV1.services.UserService;
import com.astralTinderV1.services.VoteService;
import javax.servlet.http.HttpSession;
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

    @GetMapping()
    public String ruleta(ModelMap model, HttpSession session) {

//        User currentUser = (User) session.getAttribute("randomUser");
//
//        User random = cypS.randomUser();
//        while (random.getId().equals(currentUser.getId())) {
//            random = cypS.randomUser();
//        }
//        session.setAttribute("randomUser", cypS.randomUser());
//
//        model.addAttribute("vote", new Vote());
        return "main-menu";

    }

//    @PostMapping
//    public String addLike(@ModelAttribute Vote vote, ModelMap model){
//        
//        voteService.saveVote(vote);
//        model.addAttribute("match", voteService.Match(vote));
//        return null;
//        
//    }
}
