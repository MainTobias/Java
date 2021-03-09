package com;

import java.io.UncheckedIOException;

public class Fahrrad {
    private String name = "";
    private String farbe = "";
    private int richtung = 0; // Lenkeinschlag in Grad : -45 bis +45
    private double geschwindigkeit = 0; // m/sec

    public Fahrrad(String name, String farbe, int richtung, double geschwindigkeit) {
        this.name = name;
        this.farbe = farbe;
        this.richtung = richtung;
        this.geschwindigkeit = geschwindigkeit;
    }
    public Fahrrad(String name, String farbe, int richtung) {
        this.name = name;
        this.farbe = farbe;
        this.richtung = richtung;
    }
    public Fahrrad(String name, String farbe) {
        this.name = name;
        this.farbe = farbe;
    }
    public Fahrrad() {
    }


    public static void main(String args[]) {
        Fahrrad fahrrad = new Fahrrad(" Strampler ", " blau ");
        fahrrad.lenke(10);
        fahrrad.beschleunige(.3, 9.8); // v = v + 0.3 * 9.8
        System.out.println(fahrrad);
    }
    public void lenke(int delta) {
        if (delta > 0 && richtung + delta > 45) {
            System.out.println( "Delta " + delta + " für Richtung " + richtung + " zu groß");
            return;
        } else if (delta < 0 && richtung + delta > -45) {
            System.out.println( "Delta " + delta + " für Richtung " + richtung + " zu klein");
            return;
        }
        richtung += delta;
    }

    public void beschleunige(double a, double sec){
        geschwindigkeit += a * sec;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Farbe: " + farbe + ", Richtung: " + richtung + String.format(", km/h: %.2f", geschwindigkeit*3.6);
    }
}
