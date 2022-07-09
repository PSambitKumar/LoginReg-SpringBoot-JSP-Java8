package com.sambit.Entity;

import javax.persistence.*;

@Entity
@Table
public class Package {
	@Id
	@Column
	private String packId;
	@Lob
	@Column(length = 10000)
	private String packageName;
	private String categoryCode;

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Override
	public String toString() {
		return "Package{" +
			   "packId='" + packId + '\'' +
			   ", packageName='" + packageName + '\'' +
			   ", categoryCode='" + categoryCode + '\'' +
			   '}';
	}
}
