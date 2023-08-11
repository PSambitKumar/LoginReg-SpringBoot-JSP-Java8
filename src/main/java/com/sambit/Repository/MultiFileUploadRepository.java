package com.sambit.Repository;

import com.sambit.Entity.MultiFileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 4:50 PM
 */
public interface MultiFileUploadRepository extends JpaRepository<MultiFileUpload, Integer> {
}
