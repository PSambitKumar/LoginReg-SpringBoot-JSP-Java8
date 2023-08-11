package com.sambit.Entity;

import com.sambit.Bean.PostalBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Postal {
	@Id
	@Column(name = "ofc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ofcId;

	@Column(name = "name_of_ofc")
	private String ofcName;

	@Column(name = "pincode")
	private String ofcPincode;

	@Column(name = "status")
	private String status;

	@Column(name="created_on")
	private Date createdOn;

	@Column(name="updated_on")
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
		return "Postal{" +
			   "ofcId=" + ofcId +
			   ", ofcName='" + ofcName + '\'' +
			   ", ofcPincode='" + ofcPincode + '\'' +
			   ", status='" + status + '\'' +
			   ", createdOn=" + createdOn +
			   ", updatedOn=" + updatedOn +
			   '}';
	}
}