/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author LENOVO-KL
 */
@Data
public class AuthResponse {
    private String userName;
    private List<String> authorities;

    public AuthResponse(String userName, List<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }
    
    
}
