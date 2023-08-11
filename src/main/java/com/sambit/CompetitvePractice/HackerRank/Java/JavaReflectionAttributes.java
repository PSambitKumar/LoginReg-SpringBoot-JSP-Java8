package com.sambit.CompetitvePractice.HackerRank.Java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 27/12/2022 - 11:26 PM
 */
public class JavaReflectionAttributes {
    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
