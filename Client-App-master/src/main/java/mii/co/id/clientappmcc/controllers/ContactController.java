/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.clientappmcc.models.Contact;
import mii.co.id.clientappmcc.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.thymeleaf.util.StringUtils;

/**
 *
 * @author Fadel
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

//    @GetMapping
//    public String getAll(Model model) {
//        List<Contact> contacts = new ArrayList<>();
//        for (Contact contact : contactService.getAll()) {
//            contact.setPhone(StringUtils.abbreviate(contact.getPhone(), 50));
//            contact.setLinkedin(StringUtils.abbreviate(contact.getLinkedin(), 30));
//            contacts.add(contact);
//        }
//        
//        model.addAttribute("contacts", contacts);
//        return "contact";
//    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("contacts", contactService.getAll());
        return "index";
    }
        
    @GetMapping("/get-all")
    public @ResponseBody List<Contact> getAllProcess() {
        return contactService.getAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Contact getById(@PathVariable("id") Integer id) {
        return contactService.getById(id);
    }
    
//    @GetMapping("/{id}")
//    public String getById(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("contact", contactService.getById(id));
//        return "index-form";
//    }

//    @GetMapping("/{id}")
//    public @ResponseBody Contact getById(@PathVariable("id") Integer id) {
//        return contactService.getById(id);
//    }
    
//    @PostMapping
//    public Contact create(@RequestBody Contact contact){
//        
//    }
    
//    @PutMapping("/{id}")
//    public Contact update(@PathVariable("id") Integer id, @RequestBody Contact contact) {
//
//    }

//    @DeleteMapping("/{id}")
//    public Contact delete(@PathVariable("id") Integer id) {
//
//    }

    @GetMapping("/new")
    public String addForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "index-form";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("contact") Contact contact) {
        contactService.create(contact);
        return "redirect:/contact";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("contact") Contact contact) {
        contactService.updateById(id, contact);
        return "redirect:/contact";
    }

}
