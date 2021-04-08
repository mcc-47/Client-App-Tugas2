/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.models;

import lombok.Data;

/**
 *
 * @author LENOVO-KL
 */
@Data
public class AuthRequest {
    private String userName;
    private String userPassword;

    public AuthRequest() {
    }

    public AuthRequest(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    
}
