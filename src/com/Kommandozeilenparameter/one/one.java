package com.Kommandozeilenparameter.one;


public class one {

    public static void main(String[] args) {
        if (!(args.length == 3)) {
            System.out.println("Eingabe muss z.B.: 13.4 + 16.9 sein");
            System.exit(1);
        }
        if (!(args[1].equals("+") || args[1].equals("-") || args[1].equals("x") || args[1].equals("/"))) {
            System.out.println("Fehler: Operator muss nch der ersten Zahl stehen und nach der Zweiten.");
            System.exit(1);
        }
        try {
            switch (args[1]) {
                case "+" -> System.out.printf("%5.2f + %5.2f = %5.2f", Double.parseDouble(args[0]), Double.parseDouble(args[2]), Double.parseDouble(args[0]) + Double.parseDouble(args[2]));
                case "-" -> System.out.printf("%5.2f - %5.2f = %5.2f", Double.parseDouble(args[0]), Double.parseDouble(args[2]), Double.parseDouble(args[0]) - Double.parseDouble(args[2]));
                case "x" -> System.out.printf("%5.2f x %5.2f = %5.2f", Double.parseDouble(args[0]), Double.parseDouble(args[2]), Double.parseDouble(args[0]) * Double.parseDouble(args[2]));
                case "/" -> System.out.printf("%5.2f / %5.2f = %5.2f", Double.parseDouble(args[0]), Double.parseDouble(args[2]), Double.parseDouble(args[0]) / Double.parseDouble(args[2]));
            }
        } catch (Error e) {
            System.out.print(e.toString());
        }
    }
}
