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
 * @author ROG
 */
@Data
public class AuthResponse {
    
    private String userName;
    private String employeeName;
    private List<String> authorities;

    public AuthResponse(AuthResponse ar) {
        this.userName = ar.getUserName();
        this.employeeName = ar.getEmployeeName();
        this.authorities = ar.getAuthorities();
    }

    public AuthResponse() {
    }
    
}
