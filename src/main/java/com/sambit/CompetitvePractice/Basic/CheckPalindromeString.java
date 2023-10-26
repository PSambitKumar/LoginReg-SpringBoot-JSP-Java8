package com.sambit.CompetitvePractice.Basic;

public class CheckPalindromeString {
    boolean checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();

        for (int i = 0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CheckPalindromeString obj = new CheckPalindromeString();
        System.out.println(obj.checkPalindromeString("madam"));
        System.out.println(obj.checkPalindromeString("hello"));
    }
}
