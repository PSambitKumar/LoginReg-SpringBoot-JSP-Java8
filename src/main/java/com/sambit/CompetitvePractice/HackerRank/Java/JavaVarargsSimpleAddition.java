package com.sambit.CompetitvePractice.HackerRank.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 26/12/2022 - 6:39 PM
 */

class Add {
    public void add(int... numbers) {
        int sum = 0;
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            str += numbers[i];
            if (i < numbers.length - 1) {
                str += "+";
            }
        }
        System.out.println(str + "=" + sum);
    }
}

public class JavaVarargsSimpleAddition {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);
            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

