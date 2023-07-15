package com.sambit.Utils;

import java.util.Random;

public class UserCodeGeneration {

    public static String UserCodeGenreationMethod(int maxUserSlNo){
        return "USER" + String.format("%08d", maxUserSlNo + 1);
    }

    public static String userCodeGenerationMethod(){
        return "USER" + String.format("%08d", new Random().nextInt(99999999));
    }

    public static String userCodeGenerationMethod(int maxUserSlNo){
        return "USER" + String.format("%08d", maxUserSlNo + 1);
    }

    public static String userCodeGenerationMethod(String maxUserSlNo){
        return "USER" + String.format("%08d", Integer.parseInt(maxUserSlNo) + 1);
    }
    public static void main(String[] args) {
        System.out.println(userCodeGenerationMethod());
    }
}
