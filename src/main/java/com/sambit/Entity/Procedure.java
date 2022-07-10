package com.sambit.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedure_tbl")
public class Procedure {
	@Id
	@Column
	private long id;
	private String Procedures;
	private String PackageCategoryCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProcedures() {
		return Procedures;
	}

	public void setProcedures(String procedures) {
		Procedures = procedures;
	}

	public String getPackageCategoryCode() {
		return PackageCategoryCode;
	}

	public void setPackageCategoryCode(String packageCategoryCode) {
		PackageCategoryCode = packageCategoryCode;
	}

	@Override
	public String toString() {
		return "Procedure{" +
			   "id=" + id +
			   ", Procedures='" + Procedures + '\'' +
			   ", PackageCategoryCode='" + PackageCategoryCode + '\'' +
			   '}';
	}
}
