package com.sambit.Repository;

import com.sambit.Entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDatarRepository extends JpaRepository<PersonalData, Integer> {

}
