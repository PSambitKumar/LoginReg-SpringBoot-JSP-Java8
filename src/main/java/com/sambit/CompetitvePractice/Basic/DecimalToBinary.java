package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/07/2023 - 11:43 AM
 */
public class DecimalToBinary {
    public static int getBinary(int decimal){
        int binary = 0;
        int n = 0;
        while(true){
            if(decimal == 0)
                break;
            else {
                int temp = decimal%2;
                binary += temp*Math.pow(10, n);
                decimal = decimal/2;
                n++;
            }
        }
        return binary;
    }


    public static void main(String[] args) {
        System.out.println("Binary of 10 is: "+getBinary(10));
        System.out.println("Binary of 21 is: "+getBinary(21));
        System.out.println("Binary of 31 is: "+getBinary(31));
    }
}
