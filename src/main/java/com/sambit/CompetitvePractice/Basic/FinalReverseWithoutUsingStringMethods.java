package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 21/02/2023 - 10:07 PM
 */

public class FinalReverseWithoutUsingStringMethods {

    public static void main(String[] args) {
        String str = "Automation";
        StringBuilder str2 = new StringBuilder();
        str2.append(str);
        str2 = str2.reverse();
        System.out.println(str2);
    }

}