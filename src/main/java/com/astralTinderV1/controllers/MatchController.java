package com.astralTinderV1.controllers;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enttities.Vote;
import com.astralTinderV1.services.AstralPlaneService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ruleta")
public class MatchController {
    
    private VoteService voteService;
    private ChooseYourPartnerService cypS;
    private UserService userService;
    private AstralPlaneService apServ;
    
    @Autowired
    public MatchController(VoteService voteService, ChooseYourPartnerService cypS, UserService userService, AstralPlaneService apServ) {
        this.voteService = voteService;
        this.cypS = cypS;
        this.userService = userService;
        this.apServ = apServ;
    }
    
    @GetMapping()
    public String ruleta(ModelMap model, HttpSession session) {
        
        User currentUser = (User) session.getAttribute("randomUser");
        
        User random = cypS.randomUser();
        while (currentUser != null && random.getId().equals(currentUser.getId())) {
            random = cypS.randomUser();
        }
        session.setAttribute("randomUser", random);//cypS.randomUser());
        model.addAttribute("descripcion", apServ.showArgument(random));
        model.addAttribute("vote", new Vote());
        return "main-menu";
        
    }
    
    @PostMapping("/match")
    public String addLike(@ModelAttribute Vote vote, @RequestParam User sender, @RequestParam User receiver, ModelMap model) {
        vote.setUserSend(sender);
        vote.setUserRecive(receiver);
        voteService.saveVote(vote);
        model.addAttribute("match", voteService.Match(vote));
        return "redirect:/ruleta";
        
    }
    
    @GetMapping("/listmatch")
    public String listMatch(ModelMap model, HttpSession session) {
        User currentUser = (User) session.getAttribute("userSession");
        model.put("matches", currentUser.getMatches());
        return "user-match";
    }
}
