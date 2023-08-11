package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/04/2023 - 4:59 PM
 */
public class StringReverseWithStringBuilder {
    public static void main(String[] args) {
        String str = "Automation";
        StringBuilder str2 = new StringBuilder();
        str2.append(str);
        str2.reverse();
        System.out.println(str2);
    }
}
