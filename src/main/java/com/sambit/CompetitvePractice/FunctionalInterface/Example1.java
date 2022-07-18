package com.sambit.CompetitvePractice.FunctionalInterface;

@FunctionalInterface
public interface Example1 {

//    Functional Interface Can contains only One  Abstact Method and Multiple Static Methods and Multiple Default Methods

//    Abstract Method
    void Method1();

//    Static Methods
    static void Method2(){
        System.out.println("Hello, Welcome to Method 1");
    }

//    Default Methods
    default void Method3(){
        System.out.println("Hello, Welcome to method 2");
    }
}
