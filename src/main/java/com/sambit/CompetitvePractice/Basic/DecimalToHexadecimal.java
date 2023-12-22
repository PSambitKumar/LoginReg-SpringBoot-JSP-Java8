package com.sambit.CompetitvePractice.Basic;

// Java program to convert Decimal Number
// to Hexadecimal Number

// Importing input output classes
import java.io.*;

// Main class
public class DecimalToHexadecimal {

    // Method 1
    // To convert decimal to hexadecimal
    static void decTohex(int n)
    {
        // Creating an array to store octal number
        int[] hexNum = new int[100];

        // counter for hexadecimal number array
        int i = 0;
        while (n != 0) {

            // Storing remainder in hexadecimal array
            hexNum[i] = n % 16;
            n = n / 16;
            i++;
        }

        // Printing hexadecimal number array
        // in the reverse order
        for (int j = i - 1; j >= 0; j--) {
            if (hexNum[j] > 9)
                System.out.print((char)(55 + hexNum[j]));
            else
                System.out.print(hexNum[j]);
        }
    }

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
        // Custom input decimal number
        // to be converted into hexadecimal number
        int n = 2545;

        // Calling the above Method1 over number 'n'
        // to convert this decimal into hexadecimal number
        decTohex(n);
    }
}

