/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Contact;
import com.mii.server.repositories.ContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class ContactService {
    
    @Autowired
    ContactRepository contactRepository;
    
    //Read all Data
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }
    
    //Get one Data
    public Contact getById(Integer id) {
        Optional<Contact> optional = contactRepository.findById(id);
        Contact contact = null;
        if (optional.isPresent()) {
            contact = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + id);
        }
        return contact;
    }
    
    //insert
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }
    
    public Contact updateById(Contact contactDetails, Integer id) {
        Contact contact = this.getById(id);
        contact.setContactId(contact.getContactId());
        contact.setPhone(contactDetails.getPhone());
        contact.setLinkedin(contactDetails.getLinkedin());
        return contactRepository.save(contact);
    }
    
    public void deleteById(Integer id) {
        this.contactRepository.deleteById(id);
    }
    
//    public void deleteContact(Contact contact) {
//        this.contactRepository.delete(contact);
//    }

    
    
}
