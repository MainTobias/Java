package com.basics.four;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        System.out.print("Month Yr: ");
        String[] in = new Scanner(System.in).nextLine().split(" ");
        if (!(in.length == 2)) {
            System.out.println("Error");
            System.exit(1);
        }
        switch (in[0]) {
            case "January":
                System.out.println(31);
                break;
            case "February":
                System.out.println((isLeapYear(Short.valueOf(in[1]))) ? "29" : "28");
                break;
            case "March":
                System.out.println(31);
                break;
            case "April":
                System.out.println(30);
                break;
            case "May":
                System.out.println(31);
                break;
            case "June":
                System.out.println(30);
                break;
            case "July":
                System.out.println(31);
                break;
            case "August":
                System.out.println(31);
                break;
            case "September":
                System.out.println(30);
                break;
            case "October":
                System.out.println(31);
                break;
            case "November":
                System.out.println(30);
                break;
            case "December":
                System.out.println(31);
                break;
        }
    }

    private static boolean isLeapYear(short year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

}
