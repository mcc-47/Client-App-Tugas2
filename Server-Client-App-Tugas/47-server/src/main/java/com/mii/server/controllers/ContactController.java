/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Contact;
import com.mii.server.services.ContactService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    @Autowired
    ContactService contactService;
    
    @GetMapping("")
    public ResponseEntity<List<Contact>> listContact() {
        return new ResponseEntity<>(contactService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Contact> showContact(@PathVariable Integer id) {
        return new ResponseEntity<>(contactService.getById(id), HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<Contact> insertContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.create(contact), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable Integer id) {
        return new ResponseEntity<>(contactService.updateById(contact, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable Integer id) {
        try {
            contactService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @DeleteMapping("/{id}")
//    public Map<String, Boolean> deleteContact(@PathVariable Integer id) throws Exception {
//
//        Contact contact = contactService.getContactById(id);
//        contactService.deleteContact(contact);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//
//    }
}
