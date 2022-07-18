package com.sambit.CompetitvePractice.ClassPractice;

import java.util.Objects;

public class Arithmatic {
    int addition;
    int subtraction;
    int multiplication;
    int division;

    public Arithmatic(int addition, int substraction, int multiplication, int division) {
        this.addition = addition;
        this.subtraction = substraction;
        this.multiplication = multiplication;
        this.division = division;
    }

    public int getAddition() {
        return addition;
    }

    public void setAddition(int addition) {
        this.addition = addition;
    }

    public int getSubtraction() {
        return subtraction;
    }

    public void setSubtraction(int subtraction) {
        this.subtraction = subtraction;
    }

    public int getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(int multiplication) {
        this.multiplication = multiplication;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arithmatic)) return false;
        Arithmatic that = (Arithmatic) o;
        return getAddition() == that.getAddition() && getSubtraction() == that.getSubtraction() && getMultiplication() == that.getMultiplication() && getDivision() == that.getDivision();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddition(), getSubtraction(), getMultiplication(), getDivision());
    }

    @Override
    public String toString() {
        return "Arithmatic{" +
                "addition=" + addition +
                ", subtraction=" + subtraction +
                ", multiplication=" + multiplication +
                ", division=" + division +
                '}';
    }
}
