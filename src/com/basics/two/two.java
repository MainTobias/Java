package com.basics.two;

import java.util.Locale;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        double kelvin = 0;
        double fahrenheit = 0;
        System.out.print("Celsius: ");
        double celsius = new Scanner(System.in).useLocale(Locale.UK).nextDouble();
        kelvin = celsius + 273.15;
        fahrenheit = celsius / 5.0 * 9.0 + 32.0;
        System.out.println("Fahrenheit = " + fahrenheit);
        System.out.println("Kelvin = " + kelvin);
    }
}
