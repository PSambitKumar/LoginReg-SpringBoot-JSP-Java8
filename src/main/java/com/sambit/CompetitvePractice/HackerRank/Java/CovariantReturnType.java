package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/01/2023 - 9:43 PM
 */
class Flower {
    public String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine {
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Lily {
    public String whatsYourName() {
        return "Lily";
    }
}

class Region {
    public Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal {
    public Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh {
    public Lily yourNationalFlower() {
        return new Lily();
    }
}

public class CovariantReturnType {
    public static void main(String[] args) {
        Region region = new Region();
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());

        WestBengal westBengal = new WestBengal();
        Jasmine jasmine = westBengal.yourNationalFlower();
        System.out.println(jasmine.whatsYourName());

        AndhraPradesh andhraPradesh = new AndhraPradesh();
        Lily lily = andhraPradesh.yourNationalFlower();
        System.out.println(lily.whatsYourName());
    }
}
