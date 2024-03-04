package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 04-Mar-2024 : 3:23 PM
 */

class Hospital {
    int variable1, variable2;
    double variable3;
    public Hospital(int doctors, int nurses) {
        variable1 = doctors;
        variable2 = nurses;
    }
    public Hospital(int doctors) {
        variable1 = doctors;
    }
    public Hospital(double salaries) {
        variable3 = salaries;
    }

    public static void main(String[] args) {
        Hospital obj1 = new Hospital(5, 10);
        Hospital obj2 = new Hospital(5);
        Hospital obj3 = new Hospital(25000.00);
        System.out.println("Doctors: " + obj1.variable1 + ", Nurses: " + obj1.variable2);
        System.out.println("Doctors: " + obj2.variable1);
        System.out.println("Salaries: " + obj3.variable3);
    }
}