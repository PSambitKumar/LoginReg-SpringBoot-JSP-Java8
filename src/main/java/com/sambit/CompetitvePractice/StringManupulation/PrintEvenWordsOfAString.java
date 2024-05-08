package com.sambit.CompetitvePractice.StringManupulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 08-May-2024 : 3:24 PM
 */

public class PrintEvenWordsOfAString {

    public static void main(String[] args) {
        String str = "Java is a programming language.";

        printEvenWordOfAString(str);
    }

    private static void printEvenWordOfAString(String string) {
        string = string.replaceAll("\\.", "");
        String[] strArr = string.split(" ");

        for (String str : strArr) {
            if ((str.length() % 2) == 0)
                System.out.println(str);
        }
    }

    private static void printEvenWordOfAString1(String string) {
        List<String> listString = new ArrayList<>();
    }
}
