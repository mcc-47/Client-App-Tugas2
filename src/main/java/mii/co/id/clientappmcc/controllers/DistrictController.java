/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.services.DistrictService;
import mii.co.id.clientappmcc.services.ProvinceService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("district")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private ProvinceService provinceService;
    
    @GetMapping
    public String getAll(Model model) {
        District district = new District();
        model.addAttribute("district", district);
        model.addAttribute("districts", districtService.getAll());
        model.addAttribute("provinces", provinceService.getAll());
        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authenticated.getPrincipal());
        return "district/index";
    }
    
    @GetMapping("/get-all")
    public @ResponseBody List<District> getById() {
        return districtService.getAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody District getById(@PathVariable("id") Integer id) {
        return districtService.getById(id);
    }
    
    @PostMapping("/insert")
    public @ResponseBody District insert(@RequestBody District district) {
//        return districtService.insert(district);
        System.out.println(district);
        return districtService.insert(district);
//        return "redirect:/district";
    }
    
    @PutMapping("/update/{id}")
    public @ResponseBody District update(@PathVariable("id") Integer id, @RequestBody District district) {
        System.out.println(district);
        return districtService.update(id, district);
//        return "redirect:/district";
    }
    
    @DeleteMapping("/delete/{id}")
    public @ResponseBody boolean delete(@PathVariable("id") Integer id) {
        return districtService.delete(id);
//        return "redirect:/district";
    }
}
