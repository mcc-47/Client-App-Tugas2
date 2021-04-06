/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.AuthRequest;
import mii.co.id.clientappmcc.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ROG
 */
@Controller
public class AuthController {
    
    @Autowired
    AuthService authService;
    
    @GetMapping("/login")
    public String loginPage(Model model) {
        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }
    
    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("auth") AuthRequest auth) {
        String redirectUrl = "";
        
        if (authService.loginProcess(auth)) {
            redirectUrl = "redirect:/dashboard";
        } else {
            redirectUrl = "redirect:/login?error";
        }
        
        return redirectUrl;
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
