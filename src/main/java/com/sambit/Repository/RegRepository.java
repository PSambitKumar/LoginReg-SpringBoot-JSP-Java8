package com.sambit.Repository;

import com.sambit.Entity.Reg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
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

    @Query(value = "SELECT\n" +
            "    H.HOSPITAL_NAME,\n" +
            "    H.STATE_CODE,\n" +
            "    S.STATENAME,\n" +
            "    H.DISTRICT_CODE,\n" +
            "    D.DISTRICTNAME,\n" +
            "    H.HOSPITALTYPE,\n" +
            "    H.HOSPITALPINCODE,\n" +
            "    H.HOSPITALADDRESS,\n" +
            "    H.CONTACTPERSON,\n" +
            "    H.EMAIL_ID,\n" +
            "    H.LATITUDE,\n" +
            "    H.LONGITUDE,\n" +
            "    CASE\n" +
            "        WHEN H.STATUS_FLAG = 0\n" +
            "            THEN 'ACTIVE'\n" +
            "        ELSE 'INACTIVE'\n" +
            "    END AS STATUS_FLAG\n" +
            "FROM HOSPITAL_INFO H\n" +
            "INNER JOIN STATE S ON H.STATE_CODE = S.STATECODE\n" +
            "INNER JOIN DISTRICT D ON S.STATECODE = D.STATECODE AND H.DISTRICT_CODE = D.DISTRICTCODE\n" +
            "WHERE H.STATUS_FLAG = 0\n" +
            "AND ((?2 = 'I' AND TRUNC(H.CREATED_ON) = ?1)\n" + //?1 = date, ?2 = flag (I/U) Important for Study Dynamic Query
            "OR (?2 = 'U' AND TRUNC(H.UPDATED_ON) = ?1))\n" +
            "ORDER BY H.HOSPITAL_NAME", nativeQuery = true)
    List<Object[]> getHospitalList(Date date, char flag);
}
