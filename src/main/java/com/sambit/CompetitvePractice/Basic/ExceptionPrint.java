package com.sambit.CompetitvePractice.Basic;

import java.io.IOException;

public class ExceptionPrint {

    public static void main(String[] args) {
        try {
            throw new IOException("Hello");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
