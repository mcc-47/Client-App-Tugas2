/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.services;

import client.kelompok4.clientapp.models.AuthRequest;
import client.kelompok4.clientapp.models.AuthResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * @author LENOVO-KL
 */
@Service
public class AuthService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/login")
    private String url;
    
    public boolean loginProcess(AuthRequest request){
        boolean isLoginSuccess = false;
        try {
            HttpEntity entity = new HttpEntity(request);
            ResponseEntity<AuthResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, 
                new ParameterizedTypeReference<AuthResponse>() {});
            /*panggil method untuk set spring security session*/
            setAuthorization(request.getUserName(), request.getUserPassword(), 
                response.getBody().getAuthorities());
            
            isLoginSuccess = true;
            
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        
        return isLoginSuccess;
    }
    /*Method untuk mengeset spring security session*/
    private void setAuthorization(String userName, String userPassword, List<String> authorities) {
        UsernamePasswordAuthenticationToken authToken
                = new UsernamePasswordAuthenticationToken(userName, userPassword, getListAuthorities(authorities));

        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
    
    /*List dari authorities*/
    private List<GrantedAuthority> getListAuthorities(List<String> authorities){
        return authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth))
                .collect(Collectors.toList());
    }
    
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    if (auth != null){    
//        new SecurityContextLogoutHandler().logout(request, response, auth);
//    }
//    return "redirect:/login?logout";
//}
}
