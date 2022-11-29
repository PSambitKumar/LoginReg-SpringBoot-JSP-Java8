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
    boolean existsDistinctByUserCode(String userCode);
    Reg findByUserCode(String userCode);


//    For Study Purpose Joining Of Table

//    JPQL
//    @Query("SELECT h.hospitalCode, h.hospitalName, s.stateName, d.districtname, h.status " +
//            "FROM HospitalInformation h " +
//            "LEFT JOIN State s ON h.stateCode=s.stateCode " +
//            "LEFT JOIN DistrictMaster d ON h.districtcode=d.districtcode " +
//            "WHERE h.assigned_dc = :userId ORDER BY h.hospitalId DESC")
//    List<Object[]> getHospitalInformationByDcId(Long userId);

//    NATIVE QUERY
//    @Query(value = "SELECT HOSPITAL_CODE, HOSPITAL_NAME, STATENAME, DISTRICTNAME, STATUS " +
//            "FROM HOSPITAL_INFO " +
//            "INNER JOIN STATE on HOSPITAL_INFO.STATE_CODE = STATE.STATECODE " +
//            "INNER JOIN DISTRICT on HOSPITAL_INFO.DISTRICT_CODE = DISTRICT.DISTRICTCODE " +
//            "WHERE HOSPITAL_INFO.ASSIGNED_DC = ?1", nativeQuery = true)
//    List<Object[]> getHospitalInformationList(Long userId);

//    @Query(value = "FROM MobileVersion mv WHERE mv.id = (SELECT MAX(mv1.id) FROM MobileVersion mv1)")
//    MobileVersion getMobileVersionByMaxId();
}
