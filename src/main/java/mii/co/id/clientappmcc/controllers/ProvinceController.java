/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.Province;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    /*----------------------------TEMPLATE-----------------------------------------------*/
    @GetMapping
    public String getAll(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getPrincipal().toString());
        model.addAttribute("province", provinceService.getAll());//list dari getall
        return "province/provincedt";//ke html
    }

    /*----------------------------PROSES-----------------------------------------------*/
    @GetMapping("/get-all")
    public @ResponseBody
    List<Province> getAllProcess() {
        return provinceService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Province getById(@PathVariable("id") Integer id) {
        return provinceService.getById(id);
    }

    @PostMapping("/add")
    public @ResponseBody
    Province create(@RequestBody Province province) {
        provinceService.create(province);
        return province;
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Province update(@PathVariable("id") Integer id, @RequestBody Province province) {
        System.out.println(province);
        provinceService.update(id, province);
        return province;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable("id") Integer id) {
        provinceService.delete(id);
        return "redirect:/province";
    }

    /*----------------------------BATAS-----------------------------------------------*/
}
