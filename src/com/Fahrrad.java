package com;


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
            delta = 45;
            System.out.println("Delta " + delta + " für Richtung " + richtung + " zu groß");
            return;
        } else if (delta < 0 && richtung + delta > -45) {
            delta = -45;
            System.out.println("Delta " + delta + " für Richtung " + richtung + " zu klein");
            return;
        }
        richtung += delta;
    }

    public void beschleunige(double a, double sec) {
        if (sec < 0) {
            System.out.println("Keine negative Zeit möglich!");
            return;
        }
        geschwindigkeit += a * sec;
    }

    public double getKmh() {
        return geschwindigkeit * 3.6;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Farbe: " + farbe + ", Richtung: " + richtung + String.format(", km/h: %.2f", getKmh());
    }
}

class Stadtrad extends Fahrrad {
    public static void main(String[] args) {
        Stadtrad stadtrad = new Stadtrad(" Flitzer ", " schwarz ", false);
        stadtrad.lenke(10);
        stadtrad.beschleunige(0.3, 9.8);
        stadtrad.lichtAn();
        System.out.println(stadtrad);
    }

    Stadtrad() {
        super();
    }

    Stadtrad(String name, String farbe, boolean licht) {
        super(name, farbe);
        this.licht = licht;
    }

    Stadtrad(String name, String farbe, int richtung, double geschwindigkeit, boolean licht) {
        super(name, farbe, richtung, geschwindigkeit);
        this.licht = licht;
    }

    private boolean licht;

    public void lichtAn() {
        licht = true;
    }

    public void lichtAus() {
        licht = false;
    }

    public boolean istLichtAn() {
        return licht;
    }

    @Override
    public String toString() {
        return super.toString() + ", Licht " + (licht ? "an" : "aus");
    }
}
