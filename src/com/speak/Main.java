package com.speak;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random rng = new Random();
    public static void main(String[] args) {
        Speaker[] speakers = new Speaker[100];
        for (int i = 0; i < speakers.length; i++) {
            int r = rng.nextInt(3);
            if (r == 0) {
                speakers[i] = new Person();
            } else if (r == 1) {
                speakers[i] = new Dog();
            } else if (r == 2) {
                speakers[i] = new Cat();
            }
        }
        for (Speaker speaker : speakers) {
            try {
                System.out.println(speaker.speak());
            } catch (MuteException e) {
                System.out.println(e+"");
            }
        }
    }
}
