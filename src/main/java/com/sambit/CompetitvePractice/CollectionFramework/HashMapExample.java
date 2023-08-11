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

        for (String s : hashMap.values()) {
            System.out.println(s);
        }

        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer);
        }

        for (HashMap.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }

        hashMap.forEach((integer, s) -> System.out.println("Key is: " + integer + ", Value is: " + s));

        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.containsValue("Sambit"));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.remove(2));
        System.out.println(hashMap);
        System.out.println(hashMap.replace(3, "Sambit"));
        System.out.println(hashMap);
        System.out.println(hashMap.replace(3, "Sambit", "Sambit Kumar Pradhan"));
        System.out.println(hashMap);
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.getOrDefault(2, "Sambit"));
        System.out.println(hashMap.getOrDefault(4, "Sambit"));
        System.out.println(hashMap.putIfAbsent(4, "Sambit"));
        System.out.println(hashMap);
        System.out.println(hashMap.putIfAbsent(4, "Sambit Kumar Pradhan"));
        System.out.println(hashMap);

    }
}
