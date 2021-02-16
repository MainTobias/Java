package com;

public class Konto {
    private double stand;
    private String name;
    private boolean istGiro;
    private int transaktionen;

    public Konto() {
        this("Default", 0.0, false);
    }


    public Konto(String name, double stand, boolean istGiro) {
        if (!istGiro && stand < 0) {
            this.stand = 0.0;
        } else {
            this.stand = stand;
        }
        this.name = name;
        this.istGiro = istGiro;
    }


    public static void main(String[] args) {
        Konto k1 = new Konto("Giro 1", 50.0, true);
        System.out.println(k1);
        k1.einzahlen(100);
        k1.abheben(200);
        System.out.println(k1);
        Konto k2 = new Konto("Spar 1", 50.0, false);
        System.out.println(k2);
        k2.einzahlen(100);
        k2.abheben(200);
        System.out.println(k2);
        Konto.umbuchen(k1, k2, 33);
        System.out.println(k1);
        System.out.println(k2);
    }

    public static boolean umbuchen(Konto k1, Konto k2, double betrag) {
        if (betrag == 0) {
            return false;
        } else if (betrag > 0) {
            if (k1.abheben(betrag)) {
                k2.einzahlen(betrag);
            } else {
                return false;
            }
        } else {
            return umbuchen(k1, k2, -betrag);
        }
        return true;
    }

    public boolean abheben(double i) {
        if (stand - i < 0 && !istGiro) {
            System.out.printf("Konto \"%s\" nicht gedeckt\n", name);
            return false;
        }
        stand -= i;
        transaktionen++;
        return true;
    }

    public boolean einzahlen(double i) {
        if (i <= 0.0) return false;
        stand += i;
        transaktionen++;
        return true;
    }

    @Override
    public String toString() {
        return "Kontoname: " + name + "\nStand: " + String.format(java.util.Locale.US, "%.2f", stand) + "\nTransaktionen: " + transaktionen + "\nGirokonto: " + (istGiro ? "ja" : "nein") + "\n--------------------------";
    }

}
