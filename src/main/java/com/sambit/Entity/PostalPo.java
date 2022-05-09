package com.sambit.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_cdm_postal_so", schema = "public")
public class PostalPo {
    @Id
    @Column(name = "so_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long soId;

    @ManyToOne
    @JoinColumn(name="ho_id")
    private Postal hoId;

    @Column(name = "so_name")
    private String soName;

    @Column(name = "so_pincode")
    private String soPincode;

    @Column(name = "status")
    private String status;

    @Column(name="created_on")
    private Date createdOn;

    @Column(name="updated_on")
    private Date updatedOn;

    public Long getSoId() {
        return soId;
    }

    public void setSoId(Long soId) {
        this.soId = soId;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    public String getSoPincode() {
        return soPincode;
    }

    public void setSoPincode(String soPincode) {
        this.soPincode = soPincode;
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
        return "PostalPo{" +
                "soId=" + soId +
                ", hoId=" + hoId +
                ", soName='" + soName + '\'' +
                ", soPincode='" + soPincode + '\'' +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }

    public Postal getHoId() {
        return hoId;
    }

    public void setHoId(Postal hoId) {
        this.hoId = hoId;
    }

}
