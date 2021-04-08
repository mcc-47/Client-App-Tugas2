/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.controllers;

import client.kelompok4.clientapp.models.AuthRequest;
import client.kelompok4.clientapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author LENOVO-KL
 */
@Controller
public class AuthController {
     @Autowired
    private AuthService authService;
    
//    @GetMapping("/login")
//    public String loginpage(Model model){
//        AuthRequest auth = new AuthRequest();
//        model.addAttribute("auth", auth);
//        return "login";
//    }
    
    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        if (!(authent instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/dashboard";
        }
        
        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }
    
    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("auth") AuthRequest auth){
        String redirectURL = "";
        
        if (authService.loginProcess(auth)) {
            redirectURL = "redirect:/dashboard";
        }else{
            redirectURL = "redirect:/login?error";
        }
        
        return redirectURL;
    }
    
    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    
    
}
