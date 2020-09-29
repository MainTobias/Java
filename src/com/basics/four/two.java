package com.basics.four;

import java.util.Random;

public class two {
    public static void main(String[] args) {
        Random rd = new Random();
        int points = rd.nextInt(99);
        System.out.println("Random int between 0 and 99 = " + points);
        if (points <= 59) {
            System.out.print('F');
        } else if (points <= 69) {
            System.out.print('D');
        } else if(points <= 79) {
            System.out.print('C');
        } else if(points <= 89) {
            System.out.print('B');
        } else {
            System.out.print('A');
        }
        if (points % 10 <= 1) {
            System.out.println('-');
        } else if(points % 10 >= 8) {
            System.out.println('+');
        }

    }
}
