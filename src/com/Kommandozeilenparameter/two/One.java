package com.Kommandozeilenparameter.two;

import java.util.Scanner;
//Verbesserungen:
//bei -1 keine index error mehr
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        int n = 0;
        System.out.print("m -> ");
        if(sc.hasNextInt()){
            m = sc.nextInt();
            if (m<0){
                System.out.println("Negativer index");
                System.exit(1);
            }
        } else {
            System.out.println("Fehler kein int");
            System.exit(1);
        }
        System.out.print("n -> ");
        if(sc.hasNextInt()){
            n = sc.nextInt();
            if (n<0){
                System.out.println("Negativer index");
                System.exit(1);
            }
        } else {
            System.out.println("Fehler kein int");
            System.exit(1);
        }
        if (m < args.length) {
            System.out.println("Argument: \"" + args[m] + "\"");
        } else {
            System.out.println("Argument: existiert nicht");
            System.out.println("Zeichen: existiert nicht");
            System.exit(1);
        }
        if (n < args[m].length()) {
            System.out.println("Zeichen: '" + args[m].charAt(n) + "'");
        } else {
            System.out.println("Zeichen: existiert nicht");
            System.exit(1);
        }
    }
}
