package com.sambit.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "DISTRICT")
public class District {
    @Column(name = "STATECODE", length = 2)
    private String statecode;

    @Column(name = "DISTRICTCODE", length = 4)
    private String districtcode;

    @Column(name = "DISTRICTNAME", length = 50)
    private String districtname;

    @Column(name = "S1", length = 50)
    private String s1;

    @Column(name = "S2", length = 50)
    private String s2;

    @Id
    @Column(name = "DISTRICTID", nullable = false)
    private Long districtid;

}