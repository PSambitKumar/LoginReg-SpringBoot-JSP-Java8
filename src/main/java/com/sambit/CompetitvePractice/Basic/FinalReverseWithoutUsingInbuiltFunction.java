package com.sambit.CompetitvePractice.Basic;

public class FinalReverseWithoutUsingInbuiltFunction {
    public static void main(String[] args) {
        String str = "Sambit Kumar Pradhan";
        char[] chars = str.toCharArray();
        for(int i= chars.length-1; i>=0; i--){
            System.out.print(chars[i]);
        }
    }
}
