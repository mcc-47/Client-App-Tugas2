/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class AuthRequest {
    //variabel req client disamain dg variabel req yg di service
    private String userName;
    private String userPassword;

    public AuthRequest(String username, String password) {
        this.userName = username;
        this.userPassword = password;
    }

    public AuthRequest() {
    }
}
