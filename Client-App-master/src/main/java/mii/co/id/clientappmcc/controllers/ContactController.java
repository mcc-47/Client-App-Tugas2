/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.Contact;
import mii.co.id.clientappmcc.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Fadel
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("contacts", contactService.getAll());
        return "index";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Contact> getAllProcess() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Contact getById(@PathVariable("id") Integer id) {
        return contactService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Contact update(@PathVariable("id") Integer id, @RequestBody Contact contact) {
        return contactService.updateById(id, contact);
    }

    @DeleteMapping("/{id}")
    public Contact delete(@PathVariable("id") Integer id) {
        return contactService.delete(id);
    }

}
