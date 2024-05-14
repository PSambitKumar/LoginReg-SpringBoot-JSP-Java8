package com.sambit.CompetitvePractice.StringManupulation;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 09-May-2024 : 3:31 PM
 */

public class CheckStringIsPalindromeOrNot {

    public static void main(String[] args) {
        checkStringIsPalindromeOrNot("SKS");
        checkStringIsPalindromeOrNot1("MAM");
    }

    private static void checkStringIsPalindromeOrNot(String string) {
        StringBuilder reverse = new StringBuilder();
        for (int i = string.length() - 1 ; i >= 0; i--) {
            reverse.append(string.charAt(i));
        }

        if (string.equalsIgnoreCase(reverse.toString()))
            System.out.println("Provided String is a Palindrome!");
        else
            System.out.println("Provided String is not a Palindrome!");
    }

    private static void checkStringIsPalindromeOrNot1(String string) {
        StringBuilder stringBuilder  = new StringBuilder(string).reverse();

        if (string.equalsIgnoreCase(stringBuilder.toString()))
            System.out.println("Provided String is a Palindrome!");
        else
            System.out.println("Provided String is not a Palindrome!");
    }

}
