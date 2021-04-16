/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mii.co.id.clientappmcc.models.AuthRequest;
import mii.co.id.clientappmcc.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
        if (!(authenticated instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/dashboard";
        }
        
        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }
    
    @PostMapping("/login")
    public @ResponseBody boolean loginProcess(@RequestBody AuthRequest auth) {
        String redirectUrl = "";
        boolean res = false;
        
        if (authService.loginProcess(auth)) {
            redirectUrl = "redirect:/dashboard";
            res = true;
        } else {
            redirectUrl = "redirect:/login?error";
        }
        
        return res;
    }
    
    @GetMapping("/dashboard")
    public String dashborad() {
        return "dashboard";
    }
    
    @GetMapping("/logout")
  public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();

          session = request.getSession(false);
          if(session != null) {
              session.invalidate();
          }

          for(Cookie cookie : request.getCookies()) {
              cookie.setMaxAge(0);
          }

          return "redirect:/login?logout";
  }
  
  @GetMapping("/percobaan1")
  public String percobaan(){
      return "percobaan1";
  }
  @GetMapping("/percobaan2")
  public String percobaan2(){
      return "percobaan2";
  }
  @GetMapping("/percobaan-modal")
  public String percobaanmodal(){
      return "percobaan-modal";
  }
}
