package com.sambit.CompetitvePractice.Basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-May-2024 : 6:02 PM
 */

public class ThreadsJava {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3); // Number of threads as per requirement

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> printHello(), executor);
        CompletableFuture.runAsync(() -> printHello(), executor);
        CompletableFuture.runAsync(() -> printWorld(), executor);
    }

    public static String printHello() {
        System.out.println("Hello");
        return "Hello";
    }
    public static String printWorld() {
        System.out.println("World");
        return "World";
    }

}
