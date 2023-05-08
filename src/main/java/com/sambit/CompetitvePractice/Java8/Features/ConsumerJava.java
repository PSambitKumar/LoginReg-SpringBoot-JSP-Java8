package com.sambit.CompetitvePractice.Java8.Features;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 08/05/2023 - 10:29 AM
 */
public class ConsumerJava {
    public static void main(String[] args) {
        mapConsumer();
    }

    public static void stringConsumer() {
        String name = "Sambit Kumar Pradhan";
        Consumer<String> nameConsumer = data -> System.out.println(data);
        Consumer<String> nameConsumer1 = System.out::println;//Replacing Lambda Expression with Method Reference or Embedded Method
        nameConsumer.accept("Hello " + name);
    }

    public static void integerConsumer() {
        int number = 10;
        Consumer<Integer> integerConsumer = data -> System.out.println(data);
        integerConsumer.accept( number);
    }

    public static void objectConsumer() {
        Consumer<Object> objectConsumer = data -> System.out.println(data);
        objectConsumer.accept("Hello, My Name is Sambit Kumar Pradhan \n" +
                "I am " + 25 + "Years of Old.\n"
                + "I am from Odisha, India");
    }

    public static void mapConsumer() {
        Map<Integer, String> map = Map.of(1, "Mango", 2, "Orange", 3, "Apple", 4, "Banana");

        Consumer<Map<Integer, String>> mapConsumer = data -> {
            System.out.println("Key : " + data.keySet());
            System.out.println("Value : " + data.values());

            data.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
        };
        mapConsumer.accept(map);
    }
}
