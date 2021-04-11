/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import mii.co.id.clientappmcc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ROG
 */
@Service
public class EmployeeService {
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${api.url}/employees")
    private String url;
    
     public Employee getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Employee.class).getBody();
    }
    
}
