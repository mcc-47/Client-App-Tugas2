/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author William Yangjaya
 */
@Entity
@Table(name = "district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @Column(name = "kota_kab")
    private String kotaKab;
    @Basic(optional = false)
    @Column(name = "district_name")
    private String districtName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId", fetch = FetchType.LAZY)
    private List<Subdistrict> subdistrictList;
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Province provinceId;

    public District() {
    }

    public District(Integer districtId) {
        this.districtId = districtId;
    }

    public District(Integer districtId, String kotaKab, String districtName) {
        this.districtId = districtId;
        this.kotaKab = kotaKab;
        this.districtName = districtName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getKotaKab() {
        return kotaKab;
    }

    public void setKotaKab(String kotaKab) {
        this.kotaKab = kotaKab;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @XmlTransient
    public List<Subdistrict> getSubdistrictList() {
        return subdistrictList;
    }

    public void setSubdistrictList(List<Subdistrict> subdistrictList) {
        this.subdistrictList = subdistrictList;
    }

    public Province getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.District[ districtId=" + districtId + " ]";
    }
    
}
