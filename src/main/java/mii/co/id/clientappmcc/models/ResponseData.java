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
public class ResponseData <R> {
    
    private R data;
    private String message;

    public ResponseData(R data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseData() {
    }
}