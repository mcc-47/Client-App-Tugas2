/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ROG
 */
@Data
public class AuthResponse {
    
    private String userName;
    private List<GrantedAuthority> authorities;

    public AuthResponse(String userName, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }
    
}
