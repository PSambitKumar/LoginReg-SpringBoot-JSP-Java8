package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 17/04/2023 - 10:20 AM
 */
public class DynamicQueryForARangeOfList {
    public static String generateDynamicQuery(int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        int end = pageNo * pageSize;

        System.out.println("Start: " + start + " End: " + end);

        return "SELECT * FROM (SELECT ROWNUM AS ROWNUMBER, A.* FROM (SELECT * FROM TABLE_NAME) A WHERE ROWNUM <= " + end + ") WHERE ROWNUMBER > " + start;
    }

    public static String generateDynamicQuery1(int pageNo, int pageSize) {
        int x = pageNo - 1;
        int start = (pageSize * x) + 1;
        int end = pageSize * pageNo;

        System.out.println("Start: " + start + " End: " + end);

        return "SELECT * FROM (SELECT ROWNUM AS ROWNUMBER, A.* FROM (SELECT * FROM TABLE_NAME) A WHERE ROWNUM <= " + end + ") WHERE ROWNUMBER > " + start;
    }

    public static void main(String[] args) {
        System.out.println(generateDynamicQuery(1, 10));
        System.out.println(generateDynamicQuery1(1, 10));

        System.out.println(generateDynamicQuery(2, 10));
        System.out.println(generateDynamicQuery1(2, 10));
    }
}
