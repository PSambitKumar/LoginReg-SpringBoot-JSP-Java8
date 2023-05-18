package com.sambit.CompetitvePractice.CollectionFramework;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of an HasMap ?");
        int size  = scanner.nextInt();
        HashMap<Integer, String> hashMap = new HashMap<>(size);

//        Allocating values to the HashMap
        if(hashMap.isEmpty()){
            for(int x = 1 ; x <= size; x ++){
                System.out.println("Enter name of the Employee ?");
                String name = scanner.nextLine();
                hashMap.put(x, name);
            }
        }
        else
            System.out.println("HashMap is Not Empty!!");
        System.out.println(hashMap);

//        Checks contains key
        if(hashMap.containsKey(2)){
            System.out.println(hashMap.get(2));
        }
        else
            System.out.println("Doesnot Contains Key!!");

//        Deleting a value using the key
        System.out.printf("Removing of key 1....", hashMap.remove(1));
        System.out.println(hashMap);

//        Printing each element of hashset
        for(Integer integer : hashMap.keySet()){
            System.out.println("Key is: " + integer + ", Value is: " + hashMap.get(integer));
        }

//        Printing each element of hashset using entrySet
        for(HashMap.Entry<Integer, String> entry : hashMap.entrySet()){
            System.out.println("Key is: " + entry.getKey() + ", Value is: " + entry.getValue());
        }
    }
}
