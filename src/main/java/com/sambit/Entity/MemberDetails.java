package com.sambit.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "HEALTHDEPARTMENTMEMBERDETAILS_AADHARAAUTH_LOG")
public class MemberDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEALTHDEPARTMENTMEMBERDETAILS_AADHARAAUTH_LOG_id_gen")
    @SequenceGenerator(name = "HEALTHDEPARTMENTMEMBERDETAILS_AADHARAAUTH_LOG_id_gen", sequenceName = "HEALTHDEPARTMENTMEMBERDETAILS_AADHARAAUTH_LOG_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "HEALTHMEMEBERSLNO", nullable = false)
    private Long healthMemeberSlNo;

    @Column(name = "RATIONCARDNUMBER", length = 20)
    private String rationcardNumber;

    @Column(name = "MEMBERID")
    private Long memberId;

    @Column(name = "FULLNAMEENGLISH", length = 1000)
    private String fullNameEnglish;

    @Column(name = "FULLNAMEODIYA", length = 1000)
    private String fullNameOdiya;

    @Column(name = "AADHARNUMBER", length = 20)
    private String aadharNumber;

    @Column(name = "GENDER", length = 20)
    private String gender;

    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;

    @Column(name = "AGE", length = 10)
    private String age;

    @Column(name = "RELATIONWITHFAMILYHEAD", length = 100)
    private String relationWithFamilyHead;

    @Column(name = "SCHEMETYPE", length = 20)
    private String schemeType;

    @Column(name = "MOBILENUMBER", length = 20)
    private String mobileNumber;

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
    private int statusFlag;

    @Column(name = "OLD_DATA_ID")
    private Long oldDataId;
}