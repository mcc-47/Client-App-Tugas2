/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.controllers;

import client.kelompok4.clientapp.models.District;
import client.kelompok4.clientapp.services.DistrictService;
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
 * @author LENOVO-KL
 */
@Controller
@RequestMapping("/district")
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
        model.addAttribute("districts", districtService.getById(id));
        return "district-form";
    }
     @GetMapping("/add")
    public String addForm(Model model) {
         District district = new District();
        model.addAttribute("districts", district);
        return "district-form";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("districts") District district) {
        districtService.create(district);
        return "redirect:/district";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("districts") District district) {
        districtService.update(id, district);
        return "redirect:/district";
    }
    
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Integer id,@ModelAttribute("districts") District district){
        districtService.delete(id);
        return "redirect:/district";
    }
    
}
