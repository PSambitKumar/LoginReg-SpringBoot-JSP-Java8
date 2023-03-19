package com.sambit.Repository;


import com.sambit.Entity.ProductDtl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDtlRepository extends JpaRepository<ProductDtl, Integer> {
}