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
public class Province {
    private Integer provinceId;
    private String provinceName;

    public Province() {
    }

    public Province(Province province) {
        this.provinceId = province.getProvinceId();
        this.provinceName = province.getProvinceName();
    }
    
}
