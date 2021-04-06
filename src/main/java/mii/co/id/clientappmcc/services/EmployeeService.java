/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mii.co.id.clientappmcc.models.Employee;
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
 * @author jakab
 */
@Service
public class EmployeeService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/employees")
    private String url;
    
    public List<Employee> getAll() {
        ResponseEntity<List<Employee>> response =  restTemplate
                .exchange(url+"/list-all", HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<Employee>>(){});

        return response.getBody();
    }
    
    public Employee getById(Integer id) {
        return restTemplate.getForEntity(url + "/get-one/" + id, Employee.class).getBody();
    }
    
    public void update(Integer id, Employee employee) {
        HttpEntity entity = new HttpEntity(employee);
        ResponseEntity<Employee> res = restTemplate.exchange(
                url + "/update/" + id, 
                HttpMethod.PUT, 
                entity, Employee.class);
    }
    
    public void delete(Integer id){
        ResponseEntity<Employee> res = restTemplate.exchange(
                url + "/delete/" + id, 
                HttpMethod.DELETE, 
                null, Employee.class);
    }
    
    public void create(Employee employee){
        HttpEntity entity = new HttpEntity(employee);
        ResponseEntity<Employee> res = restTemplate.exchange(
                url + "/create", 
                HttpMethod.POST, 
                entity, Employee.class);
    }
}
