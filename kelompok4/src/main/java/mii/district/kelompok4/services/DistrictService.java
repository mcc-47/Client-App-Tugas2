/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.services;

import java.util.List;
import mii.district.kelompok4.models.District;
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
 * @author ASUS
 */
@Service
public class DistrictService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}")
    private String url;
    
    //CREATE
    public void save(District district){
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<District> res = restTemplate.exchange(url+"/district/", HttpMethod.POST, entity, District.class);
    }
    
    //READ
    public List<District> getAll() {
        ResponseEntity<List<District>> response =  restTemplate
                .exchange(url+"/district", HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<District>>() {});
        
        return response.getBody();
    }
    
//    public District getById(Integer id) {
//        return restTemplate.getForEntity(url + "/" + id, District.class).getBody();
//    }
    
    //UPDATE
    public void update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<District> res = restTemplate.exchange(url + "/district/" + id, HttpMethod.PUT, entity, District.class);
    }
    
    public void create(District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<District> res = restTemplate.exchange(url+ "/district", HttpMethod.POST, entity, District.class);
    }
    
    public void delete(Integer id) {
        restTemplate.delete(url+"/district/"+id, District.class);
    }
}
