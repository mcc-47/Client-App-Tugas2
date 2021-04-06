/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import lombok.Data;

/**
 *
 * @author ACER
 */
@Data
public class Province {
    
    private Integer provinceId;
    private String provinceName;

    public Province() {
    }

    public Province(Province p) {
        this.provinceId = p.getProvinceId();
        this.provinceName = p.getProvinceName();
    }
    
    
}
