package com.sinosoft.doubledatasource.model.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 档案材料页
 */
@Entity
@Table(name = "ARCHIVE_MATERIAL_PAGE", indexes = {@Index(name = "MP_CADRE_MATERIAL_IDX",
        columnList = "CADRE_ID,MATERIAL_ID")})
public class ArchiveMaterialPage implements Serializable {
    private static final long serialVersionUID = 6750234247067511138L;
    /*
     * 主键id
     */
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    /*
     * 材料表关联
     */
    @Column(name = "MATERIAL_ID")
    private String materialId;
    /*
     * 干部表关联
     */
    @Column(name = "CADRE_ID")
    private String cadreId;

    /**
     * 状态0：正常1：已删除
     */
    @Column(name = "STATUS")
    private Integer status;
    /*
     * 页码
     */
    @Column(name = "PAGE_NUMBER")
    private Integer pageNumber;
    /*
     * 原图id
     */
    @Column(name = "IMG_ID")
    private String imgId;
    /*
     * 原图文件名
     */
    @Column(name = "IMG_NAME")
    private String imgName;
    /*
     * 原图大小
     */
    @Column(name = "IMG_SIZE")
    private Long imgSize;
    /*
     * 原图MD5
     */
    @Column(name = "IMG_MD5")
    private String imgMd5;
    /*
     * 原图最后修改时间
     */
    @Column(name = "IMG_LAST_MODIFIED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imgLastModifiedTime;
    /*
     * 原图DPI
     */
    @Column(name = "IMG_DPI")
    private Integer imgDpi;
    /*
     * 原图灰度值
     */
    @Column(name = "IMG_GRAY_SCALE")
    private Integer imgGrayScale;
    /*
     * 高清图id
     */
    @Column(name = "HD_ID")
    private String hdId;
    /*
     * 高清图文件名
     */
    @Column(name = "HD_NAME")
    private String hdName;
    /*
     * 高清图大小
     */
    @Column(name = "HD_SIZE")
    private Long hdSize;
    /*
     * 高清图MD5
     */
    @Column(name = "HD_MD5")
    private String hdMd5;
    /*
     * 高清图最后修改时间
     */
    @Column(name = "HD_LAST_MODIFIED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hdLastModifiedTime;
    /*
     * 高清图DPI
     */
    @Column(name = "HD_DPI")
    private Integer hdDpi;
    /*
     * 高清图灰度值
     */
    @Column(name = "HD_GRAY_SCALE")
    private Integer hdGrayScale;
    /*
     * 创建人
     */
    @Column(name = "CREATE_ID", length = 36)
    private String createId;
    /*
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /*
     * 修改人id
     */
    @Column(name = "MODIFY_ID", length = 36)
    private String modifyId;

    /*
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

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getCadreId() {
        return cadreId;
    }

    public void setCadreId(String cadreId) {
        this.cadreId = cadreId;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Long getImgSize() {
        return imgSize;
    }

    public void setImgSize(Long imgSize) {
        this.imgSize = imgSize;
    }

    public String getHdId() {
        return hdId;
    }

    public void setHdId(String hdId) {
        this.hdId = hdId;
    }

    public String getHdName() {
        return hdName;
    }

    public void setHdName(String hdName) {
        this.hdName = hdName;
    }

    public Long getHdSize() {
        return hdSize;
    }

    public void setHdSize(Long hdSize) {
        this.hdSize = hdSize;
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

    public String getImgMd5() {
        return imgMd5;
    }

    public void setImgMd5(String imgMd5) {
        this.imgMd5 = imgMd5;
    }

    public Date getImgLastModifiedTime() {
        return imgLastModifiedTime;
    }

    public void setImgLastModifiedTime(Date imgLastModifiedTime) {
        this.imgLastModifiedTime = imgLastModifiedTime;
    }

    public Integer getImgDpi() {
        return imgDpi;
    }

    public void setImgDpi(Integer imgDpi) {
        this.imgDpi = imgDpi;
    }

    public Integer getImgGrayScale() {
        return imgGrayScale;
    }

    public void setImgGrayScale(Integer imgGrayScale) {
        this.imgGrayScale = imgGrayScale;
    }

    public String getHdMd5() {
        return hdMd5;
    }

    public void setHdMd5(String hdMd5) {
        this.hdMd5 = hdMd5;
    }

    public Date getHdLastModifiedTime() {
        return hdLastModifiedTime;
    }

    public void setHdLastModifiedTime(Date hdLastModifiedTime) {
        this.hdLastModifiedTime = hdLastModifiedTime;
    }

    public Integer getHdDpi() {
        return hdDpi;
    }

    public void setHdDpi(Integer hdDpi) {
        this.hdDpi = hdDpi;
    }

    public Integer getHdGrayScale() {
        return hdGrayScale;
    }

    public void setHdGrayScale(Integer hdGrayScale) {
        this.hdGrayScale = hdGrayScale;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
