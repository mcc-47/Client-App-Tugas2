/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.district.kelompok4.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class AuthResponse {
    private String username;
    private List<String> authorities;

    public AuthResponse() {
    }

    public AuthResponse(String username, List<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
    
    
}
