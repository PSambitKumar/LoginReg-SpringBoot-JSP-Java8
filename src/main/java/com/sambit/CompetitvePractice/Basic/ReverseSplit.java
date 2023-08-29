package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 29-Aug-2023 : 5:45 PM
 */

public class ReverseSplit {
    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your String");
        str = in.nextLine();
        String[] token = str.split("");
        for (String s : token) {
            System.out.print(s);
        }
    }
}
