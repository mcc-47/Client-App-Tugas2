/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.services;

import client.kelompok4.clientapp.models.Province;
import java.util.List;
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
 * @author LENOVO-KL
 */
@Service
public class ProvinceService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String url;
    
    public List<Province> getAll() {
        ResponseEntity<List<Province>> response =  restTemplate
            .exchange(url+"/listprovince", HttpMethod.GET, null, 
            new ParameterizedTypeReference<List<Province>>() {});
        
    return response.getBody();
    }
    
    public Province getById(Integer id) {
        return restTemplate.getForEntity(url + "/provinceby/"+ id, Province.class).getBody();
    }
    
    //UPDATE
    public void update(Integer id, Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url + "/upd/" + id, HttpMethod.PUT, entity, Province.class);
    }
    
    //CREATE 
     public void create(Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url+"/prov", HttpMethod.POST, entity, Province.class);
    }
     
    //DELETE
     public void delete(Integer id){
      restTemplate.delete(url+ "/dlt/"+ id, Province.class);
     }
    
}
