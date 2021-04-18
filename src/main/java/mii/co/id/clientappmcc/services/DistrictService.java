/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.config.RequestFormat;
import mii.co.id.clientappmcc.models.District;
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
 * @author ACER
 */
@Service
public class DistrictService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/districts")
    private String url;
    
    public List<District> getAll() {
        ResponseEntity<List<District>> response =  restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity(RequestFormat.createHeader()), 
                new ParameterizedTypeReference<List<District>>() {});
        
        return response.getBody();
    }
    
    
    public District getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, District.class).getBody();
    }
    
    
    public District update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeader());
        ResponseEntity<District> response = restTemplate
                .exchange(url + "/" + id, HttpMethod.PUT, entity, 
                        District.class);
        return response.getBody();
    }
    
    public District insert(District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeader());
        ResponseEntity<District> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, 
                        District.class);
        return response.getBody();
    }
    
    public boolean delete(Integer id) {
        ResponseEntity<Boolean> response = restTemplate
                .exchange(url+"/"+id, HttpMethod.DELETE, new HttpEntity(RequestFormat.createHeader()), 
                        new ParameterizedTypeReference<Boolean>() {});
        return response.getBody();
    }
}
