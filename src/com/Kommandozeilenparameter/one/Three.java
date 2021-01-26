package com.Kommandozeilenparameter.one;
//Verbesserungen:
//keine
public class Three {
    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println("\"" + args[0] + "\"" + " ist enthalten in:");
            for (int i = 1; i < args.length; i++) {
                if (args[i].contains(args[0])) {
                    System.out.println(args[i]);
                }
            }

        } else {
            System.out.println("Fehler");
        }
    }
}
