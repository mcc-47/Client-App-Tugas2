/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.services;

import client.kelompok4.clientapp.config.RequestFormat;
import client.kelompok4.clientapp.models.District;
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
public class DistrictService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/districts")
    private String url;
    
    
    //READ
//    public List<District> getAll() {
//        ResponseEntity<List<District>> response =  restTemplate
//                .exchange(url+"/dist", HttpMethod.GET, null, 
//                new ParameterizedTypeReference<List<District>>() {});
//        
//        return response.getBody();
//    }
        public List<District> getAll() {
        ResponseEntity<List<District>> response =  restTemplate
                .exchange(url+"/dist", HttpMethod.GET, new HttpEntity(RequestFormat.createHeader()), 
                new ParameterizedTypeReference<List<District>>() {});
        
        return response.getBody();
    }
    
    public District getById(Integer id) {
        return restTemplate.getForEntity(url + "/disget/" + id, District.class).getBody();
    }
    
    //UPDATE
//    public void update(Integer id, District district) {
//        HttpEntity entity = new HttpEntity(district);
//        ResponseEntity<District> res = restTemplate.exchange(url + "/update/" + id, HttpMethod.PUT, entity, District.class);
//    }
    
    //RequestFormatHeader UPDATE
//    public void update(Integer id, District district) {
//        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeader());
//        ResponseEntity<District> res = restTemplate.exchange(url + "/dis-update/" + id, HttpMethod.PUT, entity, District.class);
//    }
     //UPDATE
    public void update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeader());
        ResponseEntity<String> res = restTemplate.exchange(url + "/dis-update/" + id, HttpMethod.PUT, entity, 
                new ParameterizedTypeReference<String>() {
});
    }
    
//    //CREATE 
//     public void create(District district) {
//        HttpEntity entity = new HttpEntity(district);
//        ResponseEntity<String> res = restTemplate.exchange(url+"/dis-insert", HttpMethod.POST, entity,  
//                new ParameterizedTypeReference<String>(){});
//    }
     //CREATE 
     public void create(District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeader());
        ResponseEntity<String> res = restTemplate.exchange(url+"/dis-insert", HttpMethod.POST, entity,  
                new ParameterizedTypeReference<String>(){});
    }
     
//    //DELETE
//     public void delete(Integer id){
//      restTemplate.delete(url+ "/dis-delete/" + id, District.class);
//     }
//    
     public void delete(Integer id) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<Integer> res = restTemplate.exchange(url+"/dis-delete/"+ id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<Integer>(){});
    }
    
}
