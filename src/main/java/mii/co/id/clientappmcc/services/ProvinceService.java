/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.config.RequestFormat;
import mii.co.id.clientappmcc.models.Province;
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
public class ProvinceService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/provinces")
    private String url;
    
    public List<Province> getAll() {
        ResponseEntity<List<Province>> response =  restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity(RequestFormat.createHeader()), 
                new ParameterizedTypeReference<List<Province>>() {});
        
        return response.getBody();
    }
}