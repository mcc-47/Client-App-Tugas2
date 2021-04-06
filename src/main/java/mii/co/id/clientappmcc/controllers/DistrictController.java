/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.services.DistrictService;
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
 * @author ACER
 */
@Controller
@RequestMapping("district")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("districts", districtService.getAll());
        return "district";
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("district", districtService.getById(id));
        return "district-edit-form";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("district") District district) {
        districtService.update(id, district);
        return "redirect:/district";
    }
    
    @PostMapping("/insert")
    public String insert(@ModelAttribute("district") District district) {
        districtService.insert(district);
        return "redirect:/district";
    }
    
    @GetMapping("/insert-form")
    public String getForm(Model model) {
        District district = new District();
        model.addAttribute("district", district);
        return "district-insert-form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        districtService.delete(id);
        return "redirect:/district";
    }
}
