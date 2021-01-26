package com.basics.seven;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        StringBuilder echo = new StringBuilder();
        StringBuilder reversedEcho = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            echo.append(args[i]);
            reversedEcho.append(args[args.length-1-i]);
            echo.append(" ");
            reversedEcho.append(" ");
        }
        System.out.println(echo);
        System.out.println(reversedEcho);
        System.out.println(getLength(args));
    }
    private static int getLength(String[] args){
        int length = 0;
        for (String arg : args) {
            length += arg.length();
        }
        return length;
    }
}
