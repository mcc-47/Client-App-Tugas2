/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class AuthResponse {
    
    private String userName;
    private Integer userId;
    private List<String> authorities;

    public AuthResponse(String userName, Integer userId, List<String> authorities) {
        this.userName = userName;
        this.userId = userId;
        this.authorities = authorities;
    }
    public AuthResponse() {
    }
}
