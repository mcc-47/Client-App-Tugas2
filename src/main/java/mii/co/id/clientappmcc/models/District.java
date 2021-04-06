/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author User
 */
@Data
public class District {
    private Integer districtId;
    private String kab;
    private String districtName;
    private Integer provinceId;

    public District() {
    }

    public District(District district) {
        this.districtId = district.getDistrictId();
        this.kab = district.getKab();
        this.districtName = district.getDistrictName();
        this.provinceId = district.getProvinceId();
    }
    
    
    
    
    
}
