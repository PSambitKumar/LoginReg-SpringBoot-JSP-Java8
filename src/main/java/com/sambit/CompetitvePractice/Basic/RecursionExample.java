package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 06/03/2023 - 10:58 PM
 */
public class RecursionExample {
    static int count=0;
    static void p(){
        count++;
        if(count<=5){
            System.out.println("hello "+count);
            p();
        }
    }
    public static void main(String[] args) {
        p();
    }
}
