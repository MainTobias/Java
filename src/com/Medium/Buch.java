package com.Medium;

public class Buch extends Medium{
    private final int seiten;

    public Buch(String bezeichnung, double preis, int seiten) {
        super(bezeichnung, preis);
        this.seiten = seiten;
    }

    @Override
    public void printInfo() {
        System.out.printf("Buch: %s\nPreis: %,2f\nSeiten: %s\n", super.getBezeichnung(), getPreis(), seiten);
    }

}
