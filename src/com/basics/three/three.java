package com.basics.three;

import java.util.Scanner;

/**
 * write a program that reads a name in the following format First Middle Last
 * and outputs the name formatted like this: Last, First M.
 */

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name(First Middle Last): ");
        String[] read = sc.nextLine().split(" ");
        System.out.println("\n" + read[2] + ", " + read[0] + " " + read[1].charAt(0) + ".");
    }
}
