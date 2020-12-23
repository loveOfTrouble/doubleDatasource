package com.sinosoft.doubledatasource.model.primary;


import javax.persistence.*;
import java.util.Date;

/**
 * 干部表
 */
@Entity
@Table(name = "CADRE")
public class Cadre implements java.io.Serializable {

    private static final long serialVersionUID = -2161549940752314524L;
    /**
     * 主键id
     */
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "PERSON_ID", length = 36)
    private String personId;
    /**
     * 姓名
     */
    @Column(name = "NAME", length = 200)
    private String name;
    /**
     * 姓名拼音
     */
    @Column(name = "NAME_PINYIN", length = 200)
    private String namePinYin;
    /**
     * 姓名缩写
     */
    @Column(name = "NAME_SHORT", length = 200)
    private String nameShort;
    /**
     * 身份证号
     */
    @Column(name = "ID_CARD", length = 50)
    private String idCard;
    /**
     * 性别
     */
    @Column(name = "GENDER", length = 50)
    private String gender;
    /**
     * 出生日期
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;
    /**
     * 民族
     */
    @Column(name = "NATION", length = 50)
    private String nation;
    /**
     * 籍贯
     */
    @Column(name = "NATIVEPLACE", length = 100)
    private String nativeplace;
    /**
     * 出生地
     */
    @Column(name = "BIRTHPLACE", length = 100)
    private String birthplace;
    /**
     * 政治面貌
     */
    @Column(name = "POLITIC", length = 100)
    private String politic;
    /**
     * 健康状况
     */
    @Column(name = "HEALTH_STATUS", length = 100)
    private String healthStatus;
    /**
     * 户籍所在地
     */
    @Column(name = "HOUSEHOLD_REGISTER", length = 100)
    private String householdRegister;
    /**
     * 出生地乡镇
     */
    @Column(name = "BIRTHPLACE_TOWNSHIP", length = 100)
    private String birthplaceTownship;
    /**
     * 婚姻状况
     */
    @Column(name = "MARITAL_STATUS", length = 100)
    private String maritalStatus;
    /**
     * 成长地
     */
    @Column(name = "GROWING_UP_PLACE", length = 100)
    private String growingUpPlace;
    /**
     * 统计关系所在单位代码
     */
    @Column(name = "ORGANIZATION_ID", length = 36)
    private String organizatinoId;
    /**
     * 人员管理状态
     */
    @Column(name = "MANAGEMENT_STATUS", length = 50)
    private String managementStatus;
    /**
     * 人员类别
     */
    @Column(name = "CADRE_CATEGORY", length = 100)
    private String cadreCategory;
    /**
     * 人员管理类别
     */
    @Column(name = "MANAGEMENT_CATEGORY", length = 100)
    private String managementCategory;
    /**
     * 人事关系所在单位
     */
    @Column(name = "PR_ORG", length = 36)
    private String prOrg;
    /**
     * 人事关系所在单位名称
     */
    @Column(name = "PR_ORG_NAME")
    private String prOrgName;
    /**
     * 人事关系所在单位级别
     */
    @Column(name = "PR_ORG_LEVEL", length = 100)
    private String prOrgLevel;
    /**
     * 人事关系所在单位性质类别
     */
    @Column(name = "PR_ORG_TYPE", length = 100)
    private String prOrgType;
    /**
     * 人事关系所在单位所属行业
     */
    @Column(name = "PR_ORG_INDUSTRY", length = 100)
    private String prOrgIndustry;
    /**
     * 人事关系所在单位隶属关系
     */
    @Column(name = "PR_ORG_SUBORDINATION", length = 100)
    private String prOrgSubordination;
    /**
     * 人事关系所在单位行政区划
     */
    @Column(name = "PR_ORG_REGION", length = 100)
    private String prOrgRegion;
    /**
     * 参加工作日期
     */
    @Column(name = "PARTICIOATION_DATE")
    private Date participationDate;
    /**
     * 基层工作单位
     */
    @Column(name = "GRASSROOTS_UNITS", length = 100)
    private String grassrootsUnits;
    /**
     * 工龄计算矫正值
     */
    @Column(name = "WORKING_YEAR")
    private Integer workingYear;
    /**
     * 连续工龄
     */
    @Column(name = "UNINTERRUPTED_WORKING_YEAR")
    private Integer uninterruptedWorkingYear;
    /**
     * 进入本系统工作日期
     */
    @Column(name = "ENTRY_DATE")
    private Date entryDate;
    /**
     * 现工作单位及职务
     */
    @Column(name = "POSITION", length = 500)
    private String position;
    /**
     * 是否具有基层工作经历
     */
    @Column(name = "GRASSROOTS_WORK_EXPERIENCE", length = 10)
    private String grassrootsWorkExperience;
    /**
     * 基层工作经历时间
     */
    @Column(name = "GRASSROOTS_WORK_YEARS", length = 10)
    private Integer grassrootsWorkYears;
    /**
     * 离岗退养标识
     */
    @Column(name = "RETIRE_FLAG", length = 10)
    private String retireFlag;
    /**
     * 专长
     */
    @Column(name = "EXPERTISE", length = 200)
    private String expertise;
    /**
     * 个人基本情况备注
     */
    @Column(name = "REMARK", length = 500)
    private String remark;
    /**
     * 个人身份
     */
    @Column(name = "IDENTITY", length = 100)
    private String identity;
    /**
     * 个人身份有效证件
     */
    @Column(name = "CERTIFICATE", length = 100)
    private String certificate;
    /**
     * 个人身份有效证件号
     */
    @Column(name = "CERTIFICATE_NUMBER", length = 100)
    private String certificateNumber;
    /**
     * 是否参照公务员法管理标识
     */
    @Column(name = "CIVIL_SERVICE_LAW_MANAGE", length = 10)
    private String civilServiceLawManage;
    /**
     * 档案受理人
     */
    @Column(name = "ARCHIVE_ASSIGNEE", length = 200)
    private String archiveAssignee;
    /**
     * 档案审核人
     */
    @Column(name = "ARCHIVE_APPROVAL", length = 200)
    private String archiveApproval;
    /**
     * 档案卷数
     */
    @Column(name = "ARCHIVE_NUM", length = 10)
    private Integer archiveNum;
    /**
     * 副本卷数
     */
    @Column(name = "ARCHIVE_VICE_NUM", length = 10)
    private Integer archiveViceNum;
    /**
     * 数字档案采集人
     */
    @Column(name = "ARCHIVE_COLLECT", length = 200)
    private String archiveCollect;

    /**
     * 档案总页数
     */
    @Column(name = "TOTAL_MATERIAL_COUNT")
    private Integer totalMaterialCount;

    /**
     * 档案错误数
     */
    @Column(name = "WRONG_NUM")
    private Integer wrongNum;

    /**
     * 高清数
     */
    @Column(name = "HD_WRONG_NUM")
    private Integer HDWrongNum;

    /**
     * 档案查缺数
     */
    @Column(name = "CHECK_NUM")
    private Integer checkNum;
    /**
     * 档案差缺问题的建议
     */
    @Column(name = "MATERIAL_COLLECT_MEMO", length = 500)
    private String materialCollectMemo;
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

    @Column(name = "ARCHIVE_ORG", length = 100)
    private String archiveOrg;
     /**
      * 出库入库
      * */
    @Column(name = "ARCHIVE_TYPE", length = 100)
    private String archiveType;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePinYin() {
        return namePinYin;
    }

    public void setNamePinYin(String namePinYin) {
        this.namePinYin = namePinYin;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getHouseholdRegister() {
        return householdRegister;
    }

    public void setHouseholdRegister(String householdRegister) {
        this.householdRegister = householdRegister;
    }

    public String getBirthplaceTownship() {
        return birthplaceTownship;
    }

    public void setBirthplaceTownship(String birthplaceTownship) {
        this.birthplaceTownship = birthplaceTownship;
    }

    public String getGrowingUpPlace() {
        return growingUpPlace;
    }

    public void setGrowingUpPlace(String growingUpPlace) {
        this.growingUpPlace = growingUpPlace;
    }

    public String getOrganizatinoId() {
        return organizatinoId;
    }

    public void setOrganizatinoId(String organizatinoId) {
        this.organizatinoId = organizatinoId;
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus;
    }

    public String getCadreCategory() {
        return cadreCategory;
    }

    public void setCadreCategory(String cadreCategory) {
        this.cadreCategory = cadreCategory;
    }

    public String getManagementCategory() {
        return managementCategory;
    }

    public void setManagementCategory(String managementCategory) {
        this.managementCategory = managementCategory;
    }

    public String getPrOrg() {
        return prOrg;
    }

    public void setPrOrg(String prOrg) {
        this.prOrg = prOrg;
    }

    public String getPrOrgLevel() {
        return prOrgLevel;
    }

    public void setPrOrgLevel(String prOrgLevel) {
        this.prOrgLevel = prOrgLevel;
    }

    public String getPrOrgType() {
        return prOrgType;
    }

    public void setPrOrgType(String prOrgType) {
        this.prOrgType = prOrgType;
    }

    public String getPrOrgIndustry() {
        return prOrgIndustry;
    }

    public void setPrOrgIndustry(String prOrgIndustry) {
        this.prOrgIndustry = prOrgIndustry;
    }

    public String getPrOrgSubordination() {
        return prOrgSubordination;
    }

    public void setPrOrgSubordination(String prOrgSubordination) {
        this.prOrgSubordination = prOrgSubordination;
    }

    public String getPrOrgRegion() {
        return prOrgRegion;
    }

    public void setPrOrgRegion(String prOrgRegion) {
        this.prOrgRegion = prOrgRegion;
    }

    public Date getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(Date participationDate) {
        this.participationDate = participationDate;
    }

    public String getGrassrootsUnits() {
        return grassrootsUnits;
    }

    public void setGrassrootsUnits(String grassrootsUnits) {
        this.grassrootsUnits = grassrootsUnits;
    }

    public Integer getWorkingYear() {
        return workingYear;
    }

    public void setWorkingYear(Integer workingYear) {
        this.workingYear = workingYear;
    }

    public Integer getUninterruptedWorkingYear() {
        return uninterruptedWorkingYear;
    }

    public void setUninterruptedWorkingYear(Integer uninterruptedWorkingYear) {
        this.uninterruptedWorkingYear = uninterruptedWorkingYear;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGrassrootsWorkExperience() {
        return grassrootsWorkExperience;
    }

    public void setGrassrootsWorkExperience(String grassrootsWorkExperience) {
        this.grassrootsWorkExperience = grassrootsWorkExperience;
    }

    public Integer getGrassrootsWorkYears() {
        return grassrootsWorkYears;
    }

    public void setGrassrootsWorkYears(Integer grassrootsWorkYears) {
        this.grassrootsWorkYears = grassrootsWorkYears;
    }

    public String getRetireFlag() {
        return retireFlag;
    }

    public void setRetireFlag(String retireFlag) {
        this.retireFlag = retireFlag;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getArchiveAssignee() {
        return archiveAssignee;
    }

    public void setArchiveAssignee(String archiveAssignee) {
        this.archiveAssignee = archiveAssignee;
    }

    public String getArchiveApproval() {
        return archiveApproval;
    }

    public void setArchiveApproval(String archiveApproval) {
        this.archiveApproval = archiveApproval;
    }

    public Integer getArchiveNum() {
        return archiveNum;
    }

    public void setArchiveNum(Integer archiveNum) {
        this.archiveNum = archiveNum;
    }

    public String getArchiveCollect() {
        return archiveCollect;
    }

    public void setArchiveCollect(String archiveCollect) {
        this.archiveCollect = archiveCollect;
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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCivilServiceLawManage() {
        return civilServiceLawManage;
    }

    public void setCivilServiceLawManage(String civilServiceLawManage) {
        this.civilServiceLawManage = civilServiceLawManage;
    }

    public Integer getTotalMaterialCount() {
        return totalMaterialCount;
    }

    public void setTotalMaterialCount(Integer totalMaterialCount) {
        this.totalMaterialCount = totalMaterialCount;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public Integer getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(Integer wrongNum) {
        this.wrongNum = wrongNum;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public Integer getHDWrongNum() {
        return HDWrongNum;
    }

    public void setHDWrongNum(Integer HDWrongNum) {
        this.HDWrongNum = HDWrongNum;
    }

    public String getPrOrgName() {
        return prOrgName;
    }

    public void setPrOrgName(String prOrgName) {
        this.prOrgName = prOrgName;
    }

    public Integer getArchiveViceNum() {
        return archiveViceNum;
    }

    public void setArchiveViceNum(Integer archiveViceNum) {
        this.archiveViceNum = archiveViceNum;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getArchiveOrg() {
        return archiveOrg;
    }

    public void setArchiveOrg(String archiveOrg) {
        this.archiveOrg = archiveOrg;
    }

    public String getArchiveType() {
        return archiveType;
    }

    public void setArchiveType(String archiveType) {
        this.archiveType = archiveType;
    }

    public String getMaterialCollectMemo() {
        return materialCollectMemo;
    }

    public void setMaterialCollectMemo(String materialCollectMemo) {
        this.materialCollectMemo = materialCollectMemo;
    }
}
