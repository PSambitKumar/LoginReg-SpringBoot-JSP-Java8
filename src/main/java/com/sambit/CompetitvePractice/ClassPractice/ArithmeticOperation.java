package com.sambit.CompetitvePractice.ClassPractice;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/12/2022 - 11:46 AM
 */
public class ArithmeticOperation {

   public static String getSquareOfNumber(int number){
       return String.valueOf(number*number);
   }

   public static int getSqureRootOfNumber(int number){
       return (int) Math.sqrt(number);
   }

    public static int getSumOfTwoNumber(int number1, int number2){
         return number1+number2;
    }

    public static int getSubtractionOfTwoNumber(int number1, int number2){
         return number1-number2;
    }

    public static int getMultiplicationOfTwoNumber(int number1, int number2){
         return number1*number2;
    }

    public static int getDivisionOfTwoNumber(int number1, int number2){
         return number1/number2;
    }

    public static int getModulusOfTwoNumber(int number1, int number2){
         return number1%number2;
    }

    public static void main(String[] args) {
        System.out.println("Square of 5 is: "+getSquareOfNumber(5));
        System.out.println("Square root of 25 is: "+getSqureRootOfNumber(25));
        System.out.println("Sum of 5 and 6 is: "+getSumOfTwoNumber(5,6));
        System.out.println("Subtraction of 5 and 6 is: "+getSubtractionOfTwoNumber(5,6));
        System.out.println("Multiplication of 5 and 6 is: "+getMultiplicationOfTwoNumber(5,6));
        System.out.println("Division of 5 and 6 is: "+getDivisionOfTwoNumber(5,6));
        System.out.println("Modulus of 5 and 6 is: "+getModulusOfTwoNumber(5,6));
    }
}
