package com.sambit.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 * @Project : BSKY Card Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 04-Sep-2023 : 12:49 PM
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "MST_ODISHA_ONE_SERVICE")
public class MstOdishaOneService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MST_ODISHA_ONE_SERVICE_id_gen")
    @SequenceGenerator(name = "MST_ODISHA_ONE_SERVICE_id_gen", sequenceName = "SEQ_MST_ODISHA_ONE_SERVICE", allocationSize = 1)
    @Column(name = "SERVICE_ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "SERVICE_NAME", nullable = false, length = 100)
    private String serviceName;

    @NotNull
    @Column(name = "ODISHA_ONE_SERVICE_ID", nullable = false)
    private Long odishaOneServiceId;

    @NotNull
    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @NotNull
    @Column(name = "CREATED_ON", nullable = false)
    private Date createdOn;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @NotNull
    @Column(name = "STATUS_FLAG", nullable = false)
    private Integer statusFlag;

    @Column(name = "CMS_COMPONENT_NAME")
    private String cmsComponentName;
}