/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.models.Post;
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
                .exchange(url, HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<District>>() {});
        
        return response.getBody();
    }
    
    public District getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, District.class).getBody();
    }
    
    
    public void update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<District> response = restTemplate
                .exchange(url + "/" + id, HttpMethod.PUT, entity, 
                        District.class);
    }
    
    public void insert(District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<District> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, 
                        District.class); 
    }
    
    public void delete(Integer id) {
        ResponseEntity<String> response = restTemplate
                .exchange(url+"/"+id, HttpMethod.DELETE, null, 
                        new ParameterizedTypeReference<String>() {});
    }
}
