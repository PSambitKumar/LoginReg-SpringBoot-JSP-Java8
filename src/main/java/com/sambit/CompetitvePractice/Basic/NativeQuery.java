package com.sambit.CompetitvePractice.Basic;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public static void main(String[] args) {
        NativeQuery nativeQuery = new NativeQuery();
        nativeQuery.createUniqueClaimNo();
    }
}
