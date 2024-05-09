package com.sambit.CompetitvePractice.StringManupulation;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 09-May-2024 : 12:46 PM
 */

public class StringBuilderFunctions {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("world");
        System.out.println(sb.toString()); // Output: Hello world
        
        StringBuilder sb1 = new StringBuilder("world");
        sb1.insert(0, "Hello ");
        System.out.println(sb1.toString()); // Output: Hello world

        StringBuilder sb2 = new StringBuilder("Hello world");
        sb2.delete(6, 11); // Deletes "world"
        System.out.println(sb2.toString()); // Output: Hello

        StringBuilder sb3 = new StringBuilder("Hello world");
        sb3.deleteCharAt(5); // Deletes the space at index 5
        System.out.println(sb3.toString()); // Output: Helloworld

        StringBuilder sb4 = new StringBuilder("Hello world");
        sb4.replace(0, 5, "Hi"); // Replaces "Hello" with "Hi"
        System.out.println(sb4.toString()); // Output: Hi world

        StringBuilder sb5 = new StringBuilder("Hello world");
        String sub = sb5.substring(6); // sub will contain "world"
        System.out.println(sub); // Output: world

        StringBuilder sb6 = new StringBuilder("Hello world");
        char c = sb6.charAt(6); // c will be 'w'
        System.out.println(c); // Output: w

        StringBuilder sb7 = new StringBuilder("Hello world");
        int len = sb7.length(); // len will be 11
        System.out.println(len); // Output: 11

        StringBuilder sb8 = new StringBuilder("Hello world");
        int index = sb8.indexOf("world"); // index will be 6
        System.out.println(index); // Output: 6

        StringBuilder sb9 = new StringBuilder("Hello world");
        sb9.reverse(); // sb will contain "dlrow olleH"
        System.out.println(sb9.toString()); // Output: dlrow olleH
    }
}
