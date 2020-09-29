package com.basics.three;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        System.out.print("Postleitzahl: ");
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext() && i <= 10) {
            i++;
            if (sc.hasNextInt()) {
                String plz = sc.next();
                StringBuilder out = new StringBuilder();
                switch (plz.charAt(0)) {
                    case '1':
                        out.append("Wien / Niederösterreich");
                        break;
                    case '2':
                        out.append("Niederösterreich / Burgenland");
                        break;
                    case '3':
                        out.append("Niederösterreich / Oberösterreich");
                        break;
                    case '4':
                        out.append("Oberösterreich / Niederösterreich");
                        break;
                    case '5':
                        out.append("Salzburg / Oberösterreich");
                        break;
                    case '6':
                        out.append("Tirol / Vorarlberg");
                        break;
                    case '7':
                        out.append("Burgenland");
                        break;
                    case '8':
                        out.append("Staiermark");
                        break;
                    case '9':
                        out.append("Kärten");
                        break;
                }
                out.append(" " + Integer.valueOf(plz.substring(1, 3)) + ". Bezirk, " + plz.charAt(3) + ". Postamt");
                System.out.println(out.toString());
            } else {
                System.out.println("Keine Postleitzahl!");
            }
        }
    }
}
