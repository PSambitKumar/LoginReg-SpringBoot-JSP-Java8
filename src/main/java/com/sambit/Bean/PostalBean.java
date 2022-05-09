package com.sambit.Bean;


import java.util.Date;

public class PostalBean {
    private Long ofcId;
    private String ofcName;
    private String ofcPincode;
    private String status;
    private Date createdOn;
    private Date updatedOn;

    public Long getOfcId() {
        return ofcId;
    }

    public void setOfcId(Long ofcId) {
        this.ofcId = ofcId;
    }

    public String getOfcName() {
        return ofcName;
    }

    public void setOfcName(String ofcName) {
        this.ofcName = ofcName;
    }

    public String getOfcPincode() {
        return ofcPincode;
    }

    public void setOfcPincode(String ofcPincode) {
        this.ofcPincode = ofcPincode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "PostalBean{" +
                "ofcId=" + ofcId +
                ", ofcName='" + ofcName + '\'' +
                ", ofcPincode='" + ofcPincode + '\'' +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
