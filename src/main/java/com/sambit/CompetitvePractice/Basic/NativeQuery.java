package com.sambit.CompetitvePractice.Basic;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/02/2023 - 12:00 PM
 */
@Service
public class NativeQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUniqueClaimNo() {
        String claim_No = "CL8223BC8D";
        Query query = this.entityManager.createNativeQuery("SELECT COUNT(1) FROM TXNCLAIM_APPLICATION WHERE CLAIM_NO = ?1");
        query.setParameter(1, claim_No);
        Object result = query.getSingleResult();

        int count = ((Number) result).intValue();
        System.out.println("Result is " + count);
    }

    public void getHospitalDetails(){
        Map<String, Object> response = new LinkedHashMap<>();
        List<?> results = entityManager.createNativeQuery(
                        "SELECT\n" +
                                "S.STATENAME,\n" +
                                "D.DISTRICTNAME,\n" +
                                "HOSPITAL_NAME\n" +
                                "FROM  HOSPITAL_INFO H\n" +
                                "INNER JOIN STATE S ON H.STATE_CODE = S.STATECODE\n" +
                                "INNER JOIN DISTRICT D ON  H.DISTRICT_CODE = D.DISTRICTCODE\n" +
                                "WHERE H.USER_ID = ?1")
                .setParameter(1, 1782)
                .getResultList();

        results.forEach(element -> {
            Object[] row = (Object[]) element;
            response.put("stateName", row[0]);
            response.put("districtName", row[1]);
            response.put("hospitalName", row[2]);
        });
    }

    public void getHospitalDetails1() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Object[]> results = entityManager.createNativeQuery(
                        "SELECT\n" +
                                "S.STATENAME,\n" +
                                "D.DISTRICTNAME,\n" +
                                "HOSPITAL_NAME\n" +
                                "FROM  HOSPITAL_INFO H\n" +
                                "INNER JOIN STATE S ON H.STATE_CODE = S.STATECODE\n" +
                                "INNER JOIN DISTRICT D ON  H.DISTRICT_CODE = D.DISTRICTCODE\n" +
                                "WHERE H.USER_ID = ?1")
                .setParameter(1, 1512)
                .getResultList();

        for (Object[] row : results) {
            response.put("stateName", row[0]);
            response.put("districtName", row[1]);
            response.put("hospitalName", row[2]);
            System.out.println("Data : " + response);
        }
    }

    public void getHospitalData() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Object[]> results = entityManager.createNativeQuery(
                        "SELECT\n" +
                                "            *\n" +
                                "        FROM TXNTRANSACTIONDETAILS T\n" +
                                "                 INNER JOIN HOSPITAL_INFO H ON T.HOSPITALCODE = H.HOSPITAL_CODE\n" +
                                "                 INNER JOIN STATE S ON H.STATE_CODE = S.STATECODE\n" +
                                "                 INNER JOIN DISTRICT D ON S.STATECODE = D.STATECODE AND H.DISTRICT_CODE = D.DISTRICTCODE\n" +
                                "                 INNER JOIN PACKAGEDETAILS P ON P.PROCEDURECODE = SUBSTR(T.PACKAGECODE, 5, 10) AND P.HOSPITALCATEGORYID = H.HOSPITAL_CATEGORYID\n" +
                                "        WHERE\n" +
                                "          AND H.STATUS_FLAG = 0")
                .getResultList();

        for (Object[] row : results) {
            response.put("stateName", row[0]);
            response.put("districtName", row[1]);
            response.put("hospitalName", row[2]);
            System.out.println("Data : " + response);
        }
    }



    public static void main(String[] args) {
        NativeQuery nativeQuery = new NativeQuery();
        nativeQuery.createUniqueClaimNo();
    }
}
