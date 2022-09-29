package com.sambit.Repository;

import com.sambit.Entity.Reg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegRepository extends JpaRepository<Reg, Integer> {
//    Reg findAllByUsernameAndPassword(String username, String password);
    List<Reg> findAllByUsernameAndPassword(String username, String password);
    List<Reg> findAllBySlno(int slno);
    List<Reg> findAllByPhn(String phn);
    List<Reg> findAllByUsernameAndPasswordAndName(String username, String password, String name);

    @Query("SELECT MAX (slno) FROM Reg")
    int maxSlno();

//    @Query("SELECT Reg.name FROM Reg")
//    List<String> findAllName();

    boolean existsDistinctByUsername(String userName);
}
