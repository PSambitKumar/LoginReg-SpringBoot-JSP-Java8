package com.sambit.CompetitvePractice.ClassPractice;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 09/12/2022 - 12:08 PM
 */
public class Toy {
    public void play(){
        System.out.println("Play-");
    }

    public void finalizer(){
        System.out.println("Clean-");
    }

    public static void main(String[] args) {
        Toy car = new Toy();
        car.play();
        System.gc();
        Toy doll = new Toy();
        doll.play();
    }
}
