package com.sambit.Repository;

import com.sambit.Entity.SingleFileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 3:39 PM
 */
public interface SingleFileUploadRepository extends JpaRepository<SingleFileUpload, Integer> {
}
