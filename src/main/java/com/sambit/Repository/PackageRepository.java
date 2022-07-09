package com.sambit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sambit.Entity.Package;

public interface PackageRepository extends JpaRepository<Package, String> {
}
