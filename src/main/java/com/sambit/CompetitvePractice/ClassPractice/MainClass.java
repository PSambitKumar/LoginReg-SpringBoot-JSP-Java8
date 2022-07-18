package com.sambit.CompetitvePractice.ClassPractice;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

//    Returning Single Object Method
    public static Arithmatic calculateArithmetic(int a, int b){
        int addition = a + b;
        int Subtraction = a - b;
        int multiplication = a * b;
        int division = a /b;
        return new Arithmatic(addition, Subtraction, multiplication, division);
    }

//    Returning Arraylist Method
    public static List<Object> getSingleObjectData(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("Sambit Kumar Pradhan");
        list.add('Y');
        list.add(99.99);
        return list;
    }

//    Example of Returning MMultiple Value by Various Method
//    Main Method
    public static void main(String[] args) {
        String name = null;

//        By Single Object Class
        Arithmatic arithmatic = calculateArithmetic(20, 5);
        System.out.println("Arithmetic is : " + arithmatic);
        System.out.println("HashCode is : " + arithmatic.hashCode());
        System.out.println("Addition is : " + arithmatic.getAddition());
        System.out.println("Addition is : "+ arithmatic.addition + ", Subtraction is : " + arithmatic.subtraction + ", Multiplication is : " + arithmatic.multiplication + ", Division is : " + arithmatic.division);

//        By Single Arraylist
        List<Object> list = getSingleObjectData();
        System.out.println(list);
        System.out.println("Your Name is : " + list.get(1));

        System.gc();
        Runtime.getRuntime().gc();

        System.out.println("After Garbage Collection: " + list);
    }
}
