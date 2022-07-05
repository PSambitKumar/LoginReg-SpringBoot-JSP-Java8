package com.sambit.Utils;

public class UserCodeGeneration {

    public static String UserCodeGenreationMethod(int maxUserSlNo){
        String userCode = "USER" + String.format("%08d", maxUserSlNo + 1);
        return userCode;
    }
}
