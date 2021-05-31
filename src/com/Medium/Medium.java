package com.Medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Medium {
    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

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
        String[] ss = csv.contains(",") ? csv.split(",") : csv.split(";");
        if (ss.length != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].strip();
        }
        return ss[2].contains(".") ? new AudioCD(ss[0], Double.parseDouble(ss[1]), ss[2]) : new Buch(ss[0], Double.parseDouble(ss[1]), Integer.parseInt(ss[2]));
    }

    /**
     * Liest Mediendaten aus einer übergebenen Datei aus. Fehlerhafte Zeilen werden ignoriert.
     *
     * @param filename das zu lesende File
     * @return ein Array aller gelesenen Objekte
     * @throws IOException falls die Datei nicht gelesen werden kann
     */
    public static Medium[] readFile(String filename) throws IOException {
        ArrayList<Medium> ms = new ArrayList<Medium>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String zeile;
            while ((zeile = br.readLine()) != null) {
                while (br.ready()) {
                    String line = br.readLine();
                    try {
                        ms.add(Medium.of(line));
                    } catch (Exception e) {
                        // do nothing
                    }
                }
            }
            return ms.toArray(new Medium[0]);
        } catch (IOException ioe) {
            System.out.println("Kann die Datei " + filename + " nicht lesen!");
            return new Medium[0];
        }
    }

        public abstract void printInfo ();

        /**
         * Vergleicht das <code>this</code>-Objekt mit dem übergebenen.
         *
         * @param other zu vergleichendes Objekt
         * @return eine Zahl < 0, wenn <code>this</code> billiger ist, eine Zahl > 0, wenn <code>other</code> billiger ist,
         * 0 wenn beide den gleichen Preis haben
         */
        public int compareTo (Medium other){
            return Double.compare(preis, other.preis);
        }

        /**
         * Sortiert das <code>feld</code>> aufsteigend nach Preis
         * mittels Bubble-Sort Algorithmus
         *
         * @param feld das zu sortierende Feld
         */
        public static void sort (Medium[]feld){
            int n = feld.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (feld[j].compareTo(feld[j + 1]) > 0) {
                        // swap arr[j+1] and arr[j]
                        Medium temp = feld[j];
                        feld[j] = feld[j + 1];
                        feld[j + 1] = temp;
                    }
        }

        /**
         * Zwei Medien gelten als gleich, wenn sie in Bezeichnung und Preis übereinstimmen.
         * kann generiert werden
         *
         * @param o das zu vergleichende Objekt
         */
        @Override
        public boolean equals (Object o){
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Medium m = (Medium) o;
            return preis == m.preis && bezeichnung.equals(m.bezeichnung);
        }

    }

