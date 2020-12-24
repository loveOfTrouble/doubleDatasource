package com.sinosoft.doubledatasource.model.secondary;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 页码表
 */
@Entity
@Table(name = "DA_Electronic")
public class DaElectronic {

  @Id
  @Column(name = "Elecid")
  private String elecId;

  @Column(name = "Materialid")
  private long materialId;

  @Column(name = "Persid")
  private String persId;

  @Column(name = "Typeid")
  private String typeId;

  @Column(name = "Orderid")
  private Integer orderId;

  @Column(name = "Filename")
  private String fileName;

  @Column(name = "Description")
  private String description;

  @Column(name = "Createdate")
  private Date createDate;

  public String getElecId() {
    return elecId;
  }

  public void setElecId(String elecId) {
    this.elecId = elecId;
  }

  public long getMaterialId() {
    return materialId;
  }

  public void setMaterialId(long materialId) {
    this.materialId = materialId;
  }

  public String getPersId() {
    return persId;
  }

  public void setPersId(String persId) {
    this.persId = persId;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}
