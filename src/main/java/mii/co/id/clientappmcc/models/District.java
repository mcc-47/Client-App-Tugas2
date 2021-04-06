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
public class District {
    
    private Integer districtId;
    private String kab;
    private String districtName;
    private Province provinceId;

    public District() {
    }

    public District(District d) {
        this.districtId = d.getDistrictId();
        this.kab = d.getKab();
        this.districtName = d.getDistrictName();
        this.provinceId = d.getProvinceId();
    }

}
