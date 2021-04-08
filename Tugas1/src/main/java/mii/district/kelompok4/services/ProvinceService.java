/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.services;

import java.util.List;
import mii.district.kelompok4.models.Province;
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
public class ProvinceService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/province")
    private String url;
    
    public List<Province> getAll() {
        ResponseEntity<List<Province>> response =  restTemplate
            .exchange(url, HttpMethod.GET, null, 
            new ParameterizedTypeReference<List<Province>>() {});
        
    return response.getBody();
    }
    
    public Province getById(Integer id) {
        return restTemplate.getForEntity(url + "/"+ id, Province.class).getBody();
    }
    
    
    //UPDATE
    public void update(Integer id, Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url+"/"+id, HttpMethod.PUT, entity, Province.class);
    }
    
    //CREATE 
     public void create(Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url, HttpMethod.POST, entity, Province.class);
    }
     
    //DELETE
     public void delete(Integer id){
      restTemplate.delete(url+ "/"+ id, Province.class);
     }
}
