package com.sambit.Utils;

import java.util.Random;

public class UserCodeGeneration {

    public static String UserCodeGenreationMethod(int maxUserSlNo){
        return "USER" + String.format("%08d", maxUserSlNo + 1);
    }

    public static String userCodeGenerationMethod(){
        return "USER" + String.format("%08d", new Random().nextInt(99999999));
    }
}
