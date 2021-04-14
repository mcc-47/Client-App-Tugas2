/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author William Yangjaya
 */
public class UserSessionDTO {

    private String username;

    List<String> authorities;

    public UserSessionDTO() {
    }

    public UserSessionDTO(String username, List<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    
}
