package com.sambit.Repository;

import com.sambit.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
    @Query(value = "SELECT\n" +
            "    S.STATECODE,\n" +
            "    S.STATENAME,\n" +
            "    D.DISTRICTCODE,\n" +
            "    D.DISTRICTNAME\n" +
            "FROM STATE S\n" +
            "INNER JOIN DISTRICT D ON D.STATECODE = S.STATECODE\n" +
            "WHERE S.STATECODE IN (?1)", nativeQuery = true)
    List<Object[]> getDistrictByStateCode(List<String> stateCodeList);
}