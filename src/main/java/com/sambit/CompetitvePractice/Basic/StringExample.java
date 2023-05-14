package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 25/02/2023 - 11:42 PM
 */
public class StringExample{
    public static void main(String args[]){
        String s1="java";//creating string by Java string literal
        char ch[]={'s','t','r','i','n','g','s'};
        String s2=new String(ch);//converting char array to string
        String s3=new String("example");//creating Java string by new keyword
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String s4="Sambit";
        StringBuffer sb=new StringBuffer(s4);
        sb.reverse();
        System.out.println(sb);
    }}
