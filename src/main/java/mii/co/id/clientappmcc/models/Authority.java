/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import lombok.Data;

/**
 *
 * @author ROG
 */
@Data
public class Authority {
    private String authority;

    public Authority() {
    }

    public Authority(Authority authority) {
        this.authority = authority.getAuthority();
    }
    
}
