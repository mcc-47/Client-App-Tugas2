/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.services;

import java.util.List;
import java.util.stream.Collectors;
import mii.co.id.clientappmcc.models.AuthRequest;
import mii.co.id.clientappmcc.models.AuthResponse;
import mii.co.id.clientappmcc.models.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ROG
 */
@Service
public class AuthService {
    
    @Autowired
    RestTemplate restTemplate;
    
    private final String URL = "http://localhost:8082/management/login"; 
    
    public boolean loginProcess(AuthRequest req) {
        boolean isLoginSuccess = false;
        
        try {
            HttpEntity entity = new HttpEntity(req);
            ResponseEntity<AuthResponse> res = restTemplate
                    .exchange(URL, HttpMethod.POST, entity,
                            new ParameterizedTypeReference<AuthResponse>(){
                            });
            setAuthorization(req.getUserName(), req.getPassword(), res.getBody().getAuthorities());
            
            isLoginSuccess = true;
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        
        return isLoginSuccess;
    }
    
    private void setAuthorization(String username, String password, List<String> authorities) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, password, getListAuthorities(authorities));
        
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
    
        private List<GrantedAuthority> getListAuthorities(List<String> authorities) {
            return authorities.stream()
                    .map(auth -> new SimpleGrantedAuthority(auth))
                    .collect(Collectors.toList());
        }
}
