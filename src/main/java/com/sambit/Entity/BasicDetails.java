package com.sambit.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "HEALTHDEPARTMENTBASICDETAILS_AADHARAAUTH_LOG")
public class BasicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEALTHDEPARTMENTBASICDETAILS_AADHARAAUTH_LOG_id_gen")
    @SequenceGenerator(name = "HEALTHDEPARTMENTBASICDETAILS_AADHARAAUTH_LOG_id_gen", sequenceName = "HEALTHDEPARTMENTBASICDETAILS_AADHARAAUTH_LOG_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "HEALTHSLNO", nullable = false)
    private Long healthSlNo;

    @Column(name = "RATIONCARDNUMBER", length = 20)
    private String rationCardNumber;

    @Column(name = "RATIONCARDTYPE", length = 20)
    private String rationCardType;

    @Column(name = "FULLNAMEENGLISH", length = 1000)
    private String fullNameEnglish;

    @Column(name = "FULLNAMEODIYA", length = 1000)
    private String fullNameOdiya;

    @Column(name = "AADHAARNUMBER", length = 20)
    private String aadhaarNumber;

    @Column(name = "GENDER", length = 20)
    private String gender;

    @Column(name = "SPOUSEFULLNAME", length = 1000)
    private String spouseFullName;

    @Column(name = "FATHERFULLNAME", length = 1000)
    private String fatherFullName;

    @Column(name = "MOBILENUMBER", length = 20)
    private String mobileNumber;

    @Column(name = "DISTRICT", length = 100)
    private String district;

    @Column(name = "DISTRICTID")
    private Integer districtId;

    @Column(name = "BLOCK_ULB", length = 500)
    private String blockUlb;

    @Column(name = "BLOCKID_ULBID")
    private Integer blockIdUlbId;

    @Column(name = "GP_WARD", length = 500)
    private String gpWard;

    @Column(name = "GPID_WARDID")
    private Integer gpIdWardId;

    @Column(name = "LOCALITY_VILLAGE", length = 500)
    private String localityVillage;

    @Column(name = "LOCALITYID_VILLAGEID")
    private Integer localityidVillageId;

    @Column(name = "FPSNAME", length = 500)
    private String fpsName;

    @Column(name = "SCHEMETYPE", length = 20)
    private String schemeType;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ADDITIONDELETIONSTATUS", length = 20)
    private String additionDeletionStatus;

    @Column(name = "EXPORTDATE")
    private Date exportDate;

    @Column(name = "UPDATEDATE")
    private Date updateDate;

    @Column(name = "DATA_STATUS")
    private int dataStatus;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

    @Column(name = "STATUS_FLAG")
    private Integer statusFlag;

    @Column(name = "OLD_DATA_ID")
    private Long oldDataId;
}