package com.sambit.CompetitvePractice.StringManupulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 08-May-2024 : 3:24 PM
 */

public class PrintEvenWordsOfAString {

//    Driver Code
    public static void main(String[] args) {
        String str = "Java is a programming language.";

        printEvenWordOfAString("Java is a programming language.");
        printEvenWordOfAString1("Sambit Kumar Pradhan is a student.");
        printEvenWordOfAString2("Even lengths words printing.");
    }

//    Logics
    private static void printEvenWordOfAString(String string) {
        string = string.replaceAll("\\.", "");
        String[] strArr = string.split(" ");

        for (String str : strArr) {
            if ((str.length() % 2) == 0)
                System.out.println(str);
        }
    }

    private static void printEvenWordOfAString1(String string) {
        string = string.replaceAll("\\.", "");
        for (String str : string.split(" ")) {
            if (str.length() % 2 == 0)
                System.out.println(str);
        }
    }

    private static void printEvenWordOfAString2(String string) {
        string = string.replaceAll("\\.", "");
        String[] strings = string.split(" ");

        int[] sizes = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            sizes[i] = strings[i].length();
        }

        for (int i = 0; i < sizes.length; i++) {
            if ((sizes[i] % 2) == 0)
                System.out.println(strings[i]);
        }
    }
}
