package com;

public class Portalkran {
    private int i;
    private int[] silos;
    private int max;

    public static void main(String[] args) {
        Portalkran kran = new Portalkran(5, 10);
        // 5 Silos , Maximalwert 10
        kran.fuell(4);
        kran.fuell(1);
        kran.nachRechts(2); // Kran 2 Positionen nach rechts
        kran.fuell(20); // Maximalwert 10
        kran.nachRechts(2); // Kran 2 Positionen nach rechts
        kran.fuell(1);
        kran.nachLinks(42); // ganz nach Links , keine Randueberschreitung
        int inhalt = kran.gibAlles();
        kran.nachRechts(1);
        kran.fuell(inhalt);
        System.out.println(kran);
    }

    public Portalkran() {
        this(7, 50);
    }

    public Portalkran(int length, int maxFuel) {
        this.i = 0;
        this.silos = new int[length];
        this.max = maxFuel;
    }

    public int nachRechts(int i) {
        if (i < 0) return nachLinks(-i);
        if (this.i + i < silos.length) {
            this.i += i;
        } else {
            this.i = silos.length - 1;
        }
        return this.i;
    }

    public int nachLinks(int i) {
        if (i < 0) return nachRechts(-i);
        if (this.i - i >= 0) {
            this.i -= i;
        } else {
            this.i = 0;
        }
        return this.i;
    }

    public int fuell(int x) {
        if (silos[i] + x > max) {
            silos[i] = max;
        } else if (silos[i] + x < 0) {
            silos[i] = 0;
        } else {
            silos[i] += x;
        }
        return silos[i];
    }

    public int gibAlles() {
        int before = silos[this.i];
        silos[this.i] = 0;
        return before;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < silos.length; j++) {
            sb.append("Silo " + (j + 1) + ": " + silos[j]);
            if (j == i) sb.append(" (Kranposition)");
            sb.append("\n");
        }
        return sb.toString();
    }
}
