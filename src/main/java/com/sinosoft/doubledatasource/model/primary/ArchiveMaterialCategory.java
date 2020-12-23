package com.sinosoft.doubledatasource.model.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * 档案材料类别
 */
@Entity
@Table(name = "ARCHIVE_MATERIAL_CATEGORY")
public class ArchiveMaterialCategory implements java.io.Serializable {
    private static final long serialVersionUID = -4349472866278743093L;

    /**
     * 主键id
     */
    @Id
    @Column(name = "ID", length = 36)
    private String id;
    /**
     * 编码
     */
    @Column(name = "CODE", length = 10)
    private String code;
    /**
     * 分类名称
     */
    @Column(name = "NAME", length = 200)
    private String name;
    /**
     * 父级编码
     */
    @Column(name = "PARENT_CODE", length = 10)
    private String parentCode;
    /**
     * 序号
     */
    @Column(name = "SERIAL_NUMBER", length = 20)
    private String serialNumber;
    /**
     * 档案编号
     */
    @Column(name = "ARCHIVE_NUMBER", length = 20)
    private String archiveNumber;
    /**
     * 最小档案数
     */
    @Column(name = "MIN_MATERIAL_NUM", length = 10)
    private Integer minMaterialNum;
    /**
     * 说明
     */
    @Column(name = "EXPLAIN",length = 4000)
    private String explain;
    /**
     * 密级标识
     */
    @Column(name = "security_Classified_Code")
    private Integer securityClassifiedCode;
    /**
     * 备注
     */
    @Column(name = "MEMO",length = 4000)
    private String memo;
    /**
     * 创建人
     */
    @Column(name = "CREATE_ID", length = 36)
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
    @Column(name = "MODIFY_ID", length = 36)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(String archiveNumber) {
        this.archiveNumber = archiveNumber;
    }

    public Integer getMinMaterialNum() {
        return minMaterialNum;
    }

    public void setMinMaterialNum(Integer minMaterialNum) {
        this.minMaterialNum = minMaterialNum;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getSecurityClassifiedCode() {
        return securityClassifiedCode;
    }

    public void setSecurityClassifiedCode(Integer securityClassifiedCode) {
        this.securityClassifiedCode = securityClassifiedCode;
    }
}
