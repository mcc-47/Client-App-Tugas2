/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("district")
public class DistrictController {
     
    @Autowired
     private DistrictService districtService;
    /*----------------------------TEMPLATE-----------------------------------------------*/
    @GetMapping
    public String getAll(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getPrincipal().toString());
        model.addAttribute("district", districtService.getAll());//list dari getall
        return "district/districtdt";//ke html
    }
    
    /*----------------------------PROSES-----------------------------------------------*/  
    @GetMapping("/get-all")
    public @ResponseBody List<District> getAllProcess() {
        return districtService.getAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody District getById(@PathVariable("id") Integer id) {
        return districtService.getById(id);
    }
    
    @PostMapping("/add")
    public @ResponseBody District create(@RequestBody District district) {
        districtService.create(district);
        return district;
    }
    
    @PutMapping("/{id}")
    public @ResponseBody District update (@PathVariable("id") Integer id,@RequestBody District district){
        System.out.println(district);
        districtService.update(id, district);
        return district;
    }
    
    @DeleteMapping("/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        districtService.delete(id);
         return "redirect:/district";
    }
    
     /*----------------------------BATAS-----------------------------------------------*/

    
    
    
    
}
