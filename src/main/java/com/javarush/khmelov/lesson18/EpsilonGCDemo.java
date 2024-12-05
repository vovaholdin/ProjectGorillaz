package com.javarush.khmelov.lesson18;

import java.util.concurrent.ThreadLocalRandom;

public class EpsilonGCDemo {
    public static void main(String[] args) {
        while (true) {
            String s = "Hello, world" + ThreadLocalRandom.current().nextInt(10);
            System.out.println(s);
        }
    }
}
