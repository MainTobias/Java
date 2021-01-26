package com.Kommandozeilenparameter.one;

//Verbesserungen:
//minus und division aufgrund falscher ergebnisse entfernt

public class Two {
    public static void main(String[] args) {
        if (!(args.length == 3)) {
            System.out.println("Eingabe muss z.B.: 1001101 + 1001001001 sein");
            System.exit(1);
        }
        if (!(args[1].equals("+") || args[1].equals("-") || args[1].equals("x") || args[1].equals("/"))) {
            System.out.println("Fehler: Operator muss nch der ersten Zahl stehen und nach der Zweiten.");
            System.exit(1);
        }
        try {
            int one = toDecimal(args[0]);
            int two = toDecimal(args[2]);
            if (one == -1 || two == -2) {
                System.out.println("Fehler keine binäre Zahl");
                System.exit(1);
            }
            switch (args[1]) {
                case "+" -> System.out.printf("%s + %s = %s", Integer.toBinaryString(one), Integer.toBinaryString(two), Integer.toBinaryString(one + two));
                case "x" -> System.out.printf("%s x %s = %s", Integer.toBinaryString(one), Integer.toBinaryString(two), Integer.toBinaryString(one * two));
                default -> System.out.println("Unsupported operation");
            }
        } catch (Error e) {
            System.out.print(e.toString());
        }
    }

    public static int toDecimal(String binary) {
        for (String x : binary.split("")) {
            if (!(x.equals("0") || x.equals("1"))) {
                return -1;
            }
        }
        return Integer.parseInt(binary, 2);
    }
}
