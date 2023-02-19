package com.sambit.CompetitvePractice.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 19/02/2023 - 11:11 PM
 */
public class BeforeJava8 {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result) {
            System.out.println(temp);
        }

    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"Sambit".equals(line)) {
                result.add(line);
            }
        }
        return result;
    }

}
