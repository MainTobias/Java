package com;

import java.util.Locale;
import java.util.Scanner;

public class Barplot {
    public static void main(String[] args) {
        String label = null;
        String out = null;
        System.out.print("Input: ");
        String inp = new Scanner(System.in).nextLine();
        Scanner sc = new Scanner(inp).useLocale(Locale.UK);
        if (sc.hasNext()){
            label = sc.next();
            if (sc.hasNextInt()) {
                out = drawBar(label, sc.nextInt());
            } else if(sc.hasNextDouble()) {
                out = drawBar(label, sc.nextDouble());
            } else {
                System.exit(-1);
            }
        } else {
            System.exit(-1);
        }
        // output
        if (out == null) {
            System.out.println("Error");
        } else {
            System.out.println(out);
        }
    }

    public static String repeat(char c, int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(c);
        }
        return out.toString();
    }

    public static String drawLabel(String label, int length){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < length; i++) {
            out.append((i < label.length()) ? label.charAt(i) : " ");
        }
        return out.toString();
    }

    static String drawBar(String label, double value){
        if (!(value >= 0.0 && value <= 1.0)) {
            System.out.println("Error: Double must be between 0.0 and 1.0");
            return null;
        }
        StringBuilder out = new StringBuilder(drawLabel(label, 8));
        out.append("|");
        out.append(repeat('#', (int) (Math.round(value * 30.0))));
        out.append(repeat(' ', (int) (30 - Math.round(value * 30.0))));
        out.append("|");
        return out.toString();
    }

    static String drawBar(String label, int value){
        if (!(value <= 30.0 && value >= 0.0)) {
            System.out.println("Error: Int must be between 0 and 30");
            return null;
        }
        StringBuilder out = new StringBuilder(drawLabel(label, 8));
        out.append("|");
        out.append(repeat('#', value));
        out.append(repeat(' ', 30 - value));
        out.append("|");
        return out.toString();
    }

}
