package com.zkbl.toutiaojava.greenDaoBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Create by StoneBang at 2021/9/27
 */
@Entity
public class Good {
    private String id;
    private String name;
    private String commonName;
    private String tradeName;
    private String code;
    private String spec;
    private String price;
    private String unit;
    private String supplierId;
    private String manufacturerId;
    private String implant;
    private String enable;
    private String createUserId;
    private String createDate;
    private String modifyUserId;
    private String modifyDate;
    @Generated(hash = 1450659952)
    public Good(String id, String name, String commonName, String tradeName,
            String code, String spec, String price, String unit, String supplierId,
            String manufacturerId, String implant, String enable,
            String createUserId, String createDate, String modifyUserId,
            String modifyDate) {
        this.id = id;
        this.name = name;
        this.commonName = commonName;
        this.tradeName = tradeName;
        this.code = code;
        this.spec = spec;
        this.price = price;
        this.unit = unit;
        this.supplierId = supplierId;
        this.manufacturerId = manufacturerId;
        this.implant = implant;
        this.enable = enable;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.modifyUserId = modifyUserId;
        this.modifyDate = modifyDate;
    }
    @Generated(hash = 2016981037)
    public Good() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCommonName() {
        return this.commonName;
    }
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }
    public String getTradeName() {
        return this.tradeName;
    }
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getSpec() {
        return this.spec;
    }
    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getUnit() {
        return this.unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getSupplierId() {
        return this.supplierId;
    }
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    public String getManufacturerId() {
        return this.manufacturerId;
    }
    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public String getImplant() {
        return this.implant;
    }
    public void setImplant(String implant) {
        this.implant = implant;
    }
    public String getEnable() {
        return this.enable;
    }
    public void setEnable(String enable) {
        this.enable = enable;
    }
    public String getCreateUserId() {
        return this.createUserId;
    }
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    public String getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getModifyUserId() {
        return this.modifyUserId;
    }
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
    public String getModifyDate() {
        return this.modifyDate;
    }
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
