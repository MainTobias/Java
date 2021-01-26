package com.euler;

public class five {
    public static void main(String[] args) {
        long smallestNum = 1;
        int i = 1;
        while (i < 20) {
            if (smallestNum % i == 0) {
                i++;
            } else {
                i = 1;
                smallestNum++;
            }
        }
        System.out.println(smallestNum);
    }
}
