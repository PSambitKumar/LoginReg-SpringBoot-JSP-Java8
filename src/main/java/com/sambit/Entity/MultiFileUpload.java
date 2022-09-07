package com.sambit.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "multi_file_upload")
public class MultiFileUpload implements Serializable {
	private static final long serialVersionUID = -6382297237093461519L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer multiFileUploadId;
	private String fullName;
	@Lob
	private byte[] file;
	private String originalFileName;
	private String fileContentType;

	public Integer getMultiFileUploadId() {
		return multiFileUploadId;
	}

	public void setMultiFileUploadId(Integer multiFileUploadId) {
		this.multiFileUploadId = multiFileUploadId;
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
		return "MultiFileUpload{" +
			   "multiFileUploadId=" + multiFileUploadId +
			   ", fullName='" + fullName + '\'' +
			   ", file=" + Arrays.toString(file) +
			   ", originalFileName='" + originalFileName + '\'' +
			   ", fileContentType='" + fileContentType + '\'' +
			   '}';
	}
}