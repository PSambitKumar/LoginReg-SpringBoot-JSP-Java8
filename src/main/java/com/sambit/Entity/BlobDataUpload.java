package com.sambit.Entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @Project : FileUploadDownload
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 06/09/2022 - 12:36 PM
 */

@Entity
@Table
public class BlobDataUpload {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blobId;
	@Lob
	private byte[] data;

	public int getBlobId() {
		return blobId;
	}

	public void setBlobId(int blobId) {
		this.blobId = blobId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BlobDataUpload{" +
			   "blobId=" + blobId +
			   ", data=" + Arrays.toString(data) +
			   '}';
	}
}
