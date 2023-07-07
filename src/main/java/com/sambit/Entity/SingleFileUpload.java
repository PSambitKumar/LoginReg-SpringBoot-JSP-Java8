package com.sambit.Entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 3:36 PM
 */

@Entity
@Table
public class SingleFileUpload {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int singleFileUploadId;
	private String fullName;
	@Lob
	private byte[] file;
	private String originalFileName;
	private String fileContentType;

	public int getSingleFileUploadId() {
		return singleFileUploadId;
	}

	public void setSingleFileUploadId(int singleFileUploadId) {
		this.singleFileUploadId = singleFileUploadId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	@Override
	public String toString() {
		return "SingleFileUpload{" +
			   "singleFileUploadId=" + singleFileUploadId +
			   ", fullName='" + fullName + '\'' +
			   ", file=" + Arrays.toString(file) +
			   ", originalFileName='" + originalFileName + '\'' +
			   ", fileContentType='" + fileContentType + '\'' +
			   '}';
	}
}
