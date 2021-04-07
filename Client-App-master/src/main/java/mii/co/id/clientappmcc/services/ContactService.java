/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Fadel
 */
@Service
public class ContactService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/contacts")
    private String url;

    //Read all table
    public List<Contact> getAll() {
        ResponseEntity<List<Contact>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Contact>>() {
                });

        return response.getBody();
    }

    public Contact getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Contact.class).getBody();
    }

    public void updateById(Integer id, Contact contact) {
        HttpEntity entity = new HttpEntity(contact);
        ResponseEntity<Contact> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Contact.class);
    }

    public void create(Contact contact) {
        HttpEntity entity = new HttpEntity(contact);
        ResponseEntity<Contact> res = restTemplate.exchange(url, HttpMethod.POST, entity, Contact.class);
    }
}
