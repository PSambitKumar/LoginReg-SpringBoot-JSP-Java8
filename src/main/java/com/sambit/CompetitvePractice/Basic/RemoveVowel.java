package com.sambit.CompetitvePractice.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveVowel {
    public static void main (String[]args){
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        StringBuffer strBuffer = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(!arr.contains(str.charAt(i))) {
                strBuffer.append(str.charAt(i));
            }
        }
        System.out.println("After removing Vowel from String");
        System.out.println(strBuffer);
    }
}
