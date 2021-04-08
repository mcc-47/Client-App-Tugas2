/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.controllers;

import mii.district.kelompok4.models.AuthRequest;
import mii.district.kelompok4.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @GetMapping("/login")
    public String loginpage(Model model){
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
