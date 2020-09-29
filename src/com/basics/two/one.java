package com.basics.two;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zu zahlen: ");
        if (sc.hasNextInt()) {
            int zu_zahlen = sc.nextInt();
            System.out.print("Erhalten: ");
            int erhalten = sc.nextInt();
            System.out.println("Rückgeld: " + (erhalten - zu_zahlen));
        } else {
            System.out.println("Not an Integer!");
        }
    }
}
