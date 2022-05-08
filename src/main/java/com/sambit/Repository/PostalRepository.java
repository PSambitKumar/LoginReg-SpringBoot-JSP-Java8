package com.sambit.Repository;

import com.sambit.Entity.Postal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalRepository extends JpaRepository<Postal, Long> {
    Postal findPostalHoByOfcName(String ofcName);
}
