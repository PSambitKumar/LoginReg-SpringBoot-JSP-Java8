package com.sambit.Utils;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 26/03/2023 - 11:04 PM
 */
public class StringFun {
    public static String[] splitString(String str, String delimiter){
        return str.split(delimiter);
    }

    public static String[] splitString(String str){
        return str.split(" ");
    }

    public static String[] splitString(String str, String delimiter, int limit){
        return str.split(delimiter, limit);
    }

    public static String[] splitString(String str, int limit){
        return str.split(" ", limit);
    }

    public static String[] splitString(String str, String delimiter, int limit, int offset){
        return str.split(delimiter, limit);
    }

    public static String[] splitString(String str, int limit, int offset){
        return str.split(" ", limit);
    }

    public static void main(String[] args) {
        String str = "Sambit Kumar Pradhan";
        String[] strArray = splitString(str);
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}
