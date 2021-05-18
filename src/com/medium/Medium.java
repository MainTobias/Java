package com.medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Medium  implements Comparable<Medium>{
    private String bezeichnung;
    private double preis;

    public Medium(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    /**
     * Erzeugt aus einem übergebenen String ein Medium-Objekt.
     *
     * @param csv ein csv-String. Format: bezeichnung, preis, seiten/spielzeit
     * @return ein entsprechendes Objekt
     */
    public static Medium of(String csv) {
        String[] split = csv.split(",");
        throw new IllegalArgumentException();
    }

    /**
     * Liest Mediendaten aus einer übergebenen Datei aus. Fehlerhafte Zeilen werden ignoriert.
     *
     * @param filename das zu lesende File
     * @return ein Array aller gelesenen Objekte
     * @throws IOException falls die Datei nicht gelesen werden kann
     */
    public static Medium[] readFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                String line = br.readLine();
                //TODO process line
            }
        }
        throw new UnsupportedOperationException("TODO");
    }

    public abstract void printInfo();

    /**
     * Vergleicht das <code>this</code>-Objekt mit dem übergebenen.
     *
     * @param other zu vergleichendes Objekt
     * @return eine Zahl < 0, wenn <code>this</code> billiger ist, eine Zahl > 0, wenn <code>other</code> billiger ist,
     * 0 wenn beide den gleichen Preis haben
     */
    public int compareTo(Medium other) {
        return Double.compare(preis, other.preis);
    }

    /**
     * Sortiert das <code>feld</code>> aufsteigend nach Preis
     * mittels Bubble-Sort Algorithmus
     *
     * @param feld das zu sortierende Feld
     */
    public static void sort(Medium[] feld) {
        Arrays.sort(feld);
    }

    /**
     * Zwei Medien gelten als gleich, wenn sie in Bezeichnung und Preis übereinstimmen.
     * kann generiert werden
     *
     * @param o das zu vergleichende Objekt
     */
    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Medium && ((Medium) o).preis == preis);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

