/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.controllers;

import mii.district.kelompok4.models.District;
import mii.district.kelompok4.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/district")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("district", districtService.getAll());
        return "district";
    }
 
//    @GetMapping("/{id}")
//    public String getById(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("district", districtService.getById(id));
//        return "district";
//    }
    
    
    @GetMapping("/add")
    public String addForm(Model model) {
        District district = new District();
        model.addAttribute("district", district);
        return "form-edit-district";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("district") District district) {
        districtService.create(district);
        return "redirect:/district";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("district") District district) {
        districtService.update(id, district);
        return "redirect:/district";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Integer id,@ModelAttribute("district") District district){
        districtService.delete(id);
        return "redirect:/district";
    }
}
