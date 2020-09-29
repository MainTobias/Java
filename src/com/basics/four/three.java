package com.basics.four;

import java.util.Locale;
import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        System.out.print("Term: ");
        String term = new Scanner(System.in).useLocale(Locale.UK).nextLine();
        if (term.contains("+")){
            System.out.printf("%.2f", Double.valueOf(term.replace("\\s+", "").split("\\+")[0]) + Double.valueOf(term.replace("\\s+", "").split("\\+")[1]));
        } else if(term.contains("-")) {
            System.out.printf("%.2f", Double.valueOf(term.replace("\\s+", "").split("-")[0]) - Double.valueOf(term.replace("\\s+", "").split("-")[1]));
        } else if(term.contains("*")) {
            System.out.printf("%.2f", Double.valueOf(term.replace("\\s+", "").split("\\*")[0]) * Double.valueOf(term.replace("\\s+", "").split("\\*")[1]));
        } else if(term.contains("/")) {
            System.out.printf("%.2f", Double.valueOf(term.replace("\\s+", "").split("/")[0]) / Double.valueOf(term.replace("\\s+", "").split("/")[1]));
        }
    }
}
