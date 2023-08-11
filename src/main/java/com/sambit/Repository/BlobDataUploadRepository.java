package com.sambit.Repository;

import com.sambit.Entity.BlobDataUpload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : FileUploadDownload
 * @Author : Sambit Kumar Pradhan
 * @Created On : 06/09/2022 - 12:48 PM
 */
public interface BlobDataUploadRepository extends JpaRepository<BlobDataUpload, Integer> {
}
