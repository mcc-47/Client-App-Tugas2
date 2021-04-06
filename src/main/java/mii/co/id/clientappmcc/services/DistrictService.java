/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
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
 * @author User
 */
@Service
public class DistrictService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/district")
    private String url;

    public List<District> getAll() {
        ResponseEntity<List<District>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<District>>() {
                });

        return response.getBody();
    }
    
    public void create(District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<String> res = restTemplate.exchange(url+ "/insert", HttpMethod.POST, entity,
                new ParameterizedTypeReference<String>(){});
    }
    
    public District getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, District.class).getBody();
    }
      
     public void update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district);
        ResponseEntity<String> res = restTemplate.exchange(url + "/update/" +id, HttpMethod.PUT,
                entity,new ParameterizedTypeReference<String>() {
});
    }
     
     public void delete(Integer id) {
//        ResponseEntity<District> res = restTemplate.exchange(url + "/delete/" + id, HttpMethod.DELETE, null, District.class);
        restTemplate.delete(url+"/delete/"+id,District.class);
    }
}
