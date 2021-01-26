package com;

public class Auto {
    private String typ;
    private boolean motorAn;

    public static void main(String[] args) {
        Auto a1 = new Auto ("BMW") ; // BMW , Motor aus
        Auto a2 = new Auto ("Porsche", true) ; // Porsche , Motor an
        System . out . println ( a1 ) ; // Ausgabe : BMW , Motor aus
        a1 . starten () ;
        System . out . println ( a1 ) ; // Ausgabe : BMW , Motor an
        System . out . println ( a2 ) ; // Ausgabe : Porsche , Motor an
        a2.abstellen () ;
        System.out.println(a2);
    }
    Auto() {
        this("", false);
    }
    Auto(String typ) {
        this(typ, false);
    }
    Auto(String typ, boolean motorAn) {
        this.motorAn = motorAn;
        this.typ = typ;
    }

    public void starten() {
        this.motorAn = true;
    }

    public void abstellen() {
        this.motorAn = false;
    }

    @Override
    public String toString() {
        return this.typ + ", " + (this.motorAn ? "Motor an" : "Motor aus");
    }
}
