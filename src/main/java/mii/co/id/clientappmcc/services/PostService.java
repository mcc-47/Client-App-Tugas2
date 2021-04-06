/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
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
 * @author WAHYUK
 */
@Service
public class PostService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/posts")
    private String url;
    
    public List<Post> getAll() {
        ResponseEntity<List<Post>> response =  restTemplate
                .exchange(url, HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<Post>>() {});
        
        return response.getBody();
    }
    
    public Post getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Post.class).getBody();
    }
    
    public void update(Integer id, Post post) {
        HttpEntity entity = new HttpEntity(post);
        ResponseEntity<Post> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Post.class);
    }
}
