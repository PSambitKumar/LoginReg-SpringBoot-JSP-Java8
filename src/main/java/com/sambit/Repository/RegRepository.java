package com.sambit.Repository;

import com.sambit.Entity.Reg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegRepository extends JpaRepository<Reg, Integer> {
//    Reg findAllByUsernameAndPassword(String username, String password);
    List<Reg> findAllByUsernameAndPassword(String username, String password);
    List<Reg> findAllBySlno(int slno);
}
