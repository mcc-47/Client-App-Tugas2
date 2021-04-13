/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("district")
public class DistrictController {
     @Autowired
     private DistrictService districtService;
    
    @GetMapping
    public String getAll(Model model) {
        
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getPrincipal().toString());
        model.addAttribute("district", districtService.getAll());//list dari getall
        return "districtdt";//ke html
    }
    
    @GetMapping("/nyoba")
    public String nyobaJs(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());

        return "nyobajs";//ke html
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getPrincipal().toString());
        model.addAttribute("district", districtService.getById(id));
        return "district-edit-new-2";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("district") District district) {
        districtService.update(id, district);
        return "redirect:/district";
    }
    
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        districtService.delete(id);
         return "redirect:/district";
    }
    
    @GetMapping("/add")
    public String addForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());
        District district = new District();
        model.addAttribute("district", district);
        return "district-insert-new-2";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("district") District district) {
        districtService.create(district);
        return "redirect:/district";
    }
    
    
}
