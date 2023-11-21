package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 21-Nov-2023 : 5:50 PM
 */

public class CelsiusToFahrenheit {

    public static void main(String[] args) {
        float celsius, fahrenheit;
        System.out.println("Program to convert Celsius to Fahrenheit" );
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give the Celsius Temperature");
        celsius= sc.nextFloat();
        fahrenheit = (celsius * 9 / 5) + 32;
        System.out.printf("Fahrenheit = %.2f",fahrenheit);
    }
}
