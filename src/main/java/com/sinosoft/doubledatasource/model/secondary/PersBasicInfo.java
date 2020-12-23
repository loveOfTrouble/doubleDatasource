package com.sinosoft.doubledatasource.model.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/22
 */
@Entity
@Table(name = "DA_Persbasicinfo")
public class PersBasicInfo {

    /*
     * 主键id
     */
    @Id
    @Column(name = "Persid", length = 36)
    private String persID;

    /**
     * 姓名
     */
    @Column(name = "A0101", length = 30)
    private String name;


    /**
     * 身份证
     */
    @Column(name = "A0184", length = 36)
    private String idCard;


    public String getPersID() {
        return persID;
    }

    public void setPersID(String persID) {
        this.persID = persID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
