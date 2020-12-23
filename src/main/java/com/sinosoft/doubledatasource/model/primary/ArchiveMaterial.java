package com.sinosoft.doubledatasource.model.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * 档案材料表
 */
@Entity
@Table(name = "ARCHIVE_MATERIAL", indexes = {@Index(name = "M_CADRE_ID_IDX",
        columnList = "CADRE_ID")})
public class ArchiveMaterial implements java.io.Serializable {

    private static final long serialVersionUID = -5110087852968333255L;
    /**
     * 主键id
     */
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    /**
     * 材料类别表关联
     */
    @Column(name = "CATEGORY_ID")
    private String categoryId;

    /**
     * 干部表关联
     */
    @Column(name = "CADRE_ID")
    private String cadreId;

    /**
     * 材料名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 总页数
     */
    @Column(name = "PAGE_COUNT")
    private Integer pageCount;

    /**
     * 材料形成时间
     */
    @Column(name = "ENTRY_DATE")
    private Date entryDate;

    /*
     * 材料形成日期字符串
     */
    @Column(name = "ENTRY_DATE_STR")
    private String entryDateStr;

    /**
     * 排序号
     */
    @Column(name = "SORT_NUMBER")
    private Integer sortNumber;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;
    /**
     * 状态（-1：已删除，1：正常）
     */
    @Column(name = "STATUS")
    private Integer status;
    /**
     * 创建人
     */
    @Column(name = "CREATE_ID")
    private String createId;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 修改人
     */
    @Column(name = "MODIFY_ID")
    private String modifyId;
    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCadreId() {
        return cadreId;
    }

    public void setCadreId(String cadreId) {
        this.cadreId = cadreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEntryDateStr() {
        return entryDateStr;
    }

    public void setEntryDateStr(String entryDateStr) {
        this.entryDateStr = entryDateStr;
    }
}
