package com.sambit.CompetitvePractice.StringManupulation;

import com.microsoft.schemas.office.office.STInsetMode;

import java.util.Scanner;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 09-May-2024 : 12:15 PM
 */

public class InsertAStringToAnotherString {

//    Driver Code
    public  static void  main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Main String ?");
        String mainString = scanner.nextLine();

        System.out.println("Enter Insertion String ?");
        String insertString = scanner.nextLine();

        System.out.println("Enter Index ?");
        int index = scanner.nextInt();*/

        insertStringToAnotherString("SambitPradhan", "Kumar", 5);
        insertStringToAnotherString1("SambitPradhan", "Kumar", 5);
        insertStringToAnotherString2("SambitPradhan", "Kumar", 5);
    }

//    Logics
    private static void insertStringToAnotherString(String mainString, String insertString, int index) {
        String firstString = mainString.substring(0, index + 1);
        String secondString = mainString.substring(index + 1);

        String newString = firstString + insertString + secondString;

        System.out.println("New String: " + newString);
    }

    private static void insertStringToAnotherString1(String mainString, String insertString, int index) {
        StringBuilder stringBuilder = new StringBuilder(mainString);
        stringBuilder.insert(index + 1, insertString);

        System.out.println(stringBuilder.toString());
    }

    private static void insertStringToAnotherString2(String mainString, String insertString, int index) {
        char[] firstCharArr = (mainString.substring(0, index + 1).toCharArray());
        char[] secondCharArr = (mainString.substring(index + 1).toCharArray());
        char[] insertCharArr = insertString.toCharArray();

        int combinedLength = firstCharArr.length + secondCharArr.length + insertCharArr.length;

        char[] combinedCharArr = new char[combinedLength];

        System.arraycopy(firstCharArr, 0, combinedCharArr, 0, firstCharArr.length);
        System.arraycopy(insertCharArr, 0, combinedCharArr, firstCharArr.length, insertCharArr.length);
        System.arraycopy(secondCharArr, 0, combinedCharArr, firstCharArr.length + insertCharArr.length, secondCharArr.length);

        String result = new String(combinedCharArr);
        System.out.println("Final String: " + result);
    }
}
