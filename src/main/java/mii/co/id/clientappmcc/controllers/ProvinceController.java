/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.Province;
import mii.co.id.clientappmcc.services.ProvinceService;
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
@RequestMapping("province")
public class ProvinceController {
    
    @Autowired
    ProvinceService provinceService;
    
    @GetMapping
    public String getAll(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());
        model.addAttribute("province", provinceService.getAll());//list dari getall
        return "provincenew2";//ke html
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());
        model.addAttribute("province", provinceService.getById(id));
        return "province-edit-new-2";
    }
    
    @GetMapping("/add")
    public String addForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());
        Province province = new Province();
        model.addAttribute("province", province);
        return "province-insert-new-2";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("province") Province province) {
        provinceService.create(province);
        return "redirect:/province";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        provinceService.delete(id);
         return "redirect:/province";
    }
    
     @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("province") Province province) {
        provinceService.update(id, province);
        return "redirect:/province";
    }
}
