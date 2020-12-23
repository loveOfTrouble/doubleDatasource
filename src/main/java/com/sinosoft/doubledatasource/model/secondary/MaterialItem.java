package com.sinosoft.doubledatasource.model.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/22
 */
@Entity
@Table(name = "DA_Materialitem")
public class MaterialItem {

    @Id
    @Column(name = "Materialid", length = 36)
    private String materialID;

    @Column(name = "Persid", length = 36)
    private String persID;

    @Column(name = "Materialtype", length = 4)
    private String materialType;

    @Column(name = "Orderid")
    private Integer orderID;

    @Column(name = "codevalue", length = 10)
    private String codeValue;

    @Column(name = "Description", length = 100)
    private String description;

    @Column(name = "Createdate", length = 20)
    private String createDate;

    @Column(name = "Sharenumber")
    private Integer shareNumber;

    @Column(name = "Pagenumber")
    private Integer pageNumber;

    @Column(name = "Remark", length = 500)
    private String remark;

    @Column(name = "Auditingstate", length = 1)
    private String auditingState;

    @Column(name = "YScanpage", length = 1)
    private Integer YScanPage;

    @Column(name = "Highscan", length = 10)
    private String highScan;

    @Column(name = "Highscanpage")
    private Integer highScanPage;

    @Column(name = "Lowscan", length = 10)
    private String lowScan;

    @Column(name = "Lowscanpage")
    private Integer lowScanPage;

    @Column(name = "Scanper", length = 30)
    private String scanPer;

    @Column(name = "Scantime")
    private Date scanTime;

    @Column(name = "Endscanstate", length = 10)
    private String endScanState;

    @Column(name = "Threeagematerial", length = 1)
    private String threeAgeMaterial;

    @Column(name = "Materialscanarea", length = 10)
    private String materialScanArea;

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getPersID() {
        return persID;
    }

    public void setPersID(String persID) {
        this.persID = persID;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Integer shareNumber) {
        this.shareNumber = shareNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditingState() {
        return auditingState;
    }

    public void setAuditingState(String auditingState) {
        this.auditingState = auditingState;
    }

    public Integer getYScanPage() {
        return YScanPage;
    }

    public void setYScanPage(Integer YScanPage) {
        this.YScanPage = YScanPage;
    }

    public String getHighScan() {
        return highScan;
    }

    public void setHighScan(String highScan) {
        this.highScan = highScan;
    }

    public Integer getHighScanPage() {
        return highScanPage;
    }

    public void setHighScanPage(Integer highScanPage) {
        this.highScanPage = highScanPage;
    }

    public String getLowScan() {
        return lowScan;
    }

    public void setLowScan(String lowScan) {
        this.lowScan = lowScan;
    }

    public Integer getLowScanPage() {
        return lowScanPage;
    }

    public void setLowScanPage(Integer lowScanPage) {
        this.lowScanPage = lowScanPage;
    }

    public String getScanPer() {
        return scanPer;
    }

    public void setScanPer(String scanPer) {
        this.scanPer = scanPer;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public String getEndScanState() {
        return endScanState;
    }

    public void setEndScanState(String endScanState) {
        this.endScanState = endScanState;
    }

    public String getThreeAgeMaterial() {
        return threeAgeMaterial;
    }

    public void setThreeAgeMaterial(String threeAgeMaterial) {
        this.threeAgeMaterial = threeAgeMaterial;
    }

    public String getMaterialScanArea() {
        return materialScanArea;
    }

    public void setMaterialScanArea(String materialScanArea) {
        this.materialScanArea = materialScanArea;
    }
}
