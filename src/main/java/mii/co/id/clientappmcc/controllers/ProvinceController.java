/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("province", provinceService.getAll());//list dari getall
        return "province";//ke html
    }
    
}
