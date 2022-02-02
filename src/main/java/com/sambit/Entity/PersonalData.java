package com.sambit.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PersonalData")
public class PersonalData {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    @Column
    private String name;
    @Column
    private String panId;
    @Column
    private int adharNo;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId;
    }

    public int getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(int adharNo) {
        this.adharNo = adharNo;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", panId='" + panId + '\'' +
                ", adharNo=" + adharNo +
                '}';
    }
}
