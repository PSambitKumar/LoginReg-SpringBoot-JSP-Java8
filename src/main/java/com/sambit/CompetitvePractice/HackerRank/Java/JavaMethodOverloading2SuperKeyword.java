package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 01/12/2022 - 9:38 AM
 */
class BiCycle{
    String define_me(){
        return "a vehicle with pedals.";
    }
}



class MotorCycle extends BiCycle{
    String define_me(){
        return "a cycle with an engine.";
    }
    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        String temp = super.define_me();
        System.out.println("My ancestor is a cycle who is " + temp);
    }
}

public class JavaMethodOverloading2SuperKeyword {
    public static void main(String []args){
        MotorCycle M=new MotorCycle();
    }
}
