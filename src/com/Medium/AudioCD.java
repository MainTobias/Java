package com.Medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AudioCD extends Medium{
    private final String spielzeit;

    public AudioCD(String bezeichnung, double preis, String spielzeit) {
        super(bezeichnung, preis);
        Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(spielzeit);
        boolean matchFound = matcher.matches();
        if (!matchFound) {
            throw new IllegalArgumentException();
        }
        this.spielzeit = spielzeit;
    }

    @Override
    public void printInfo() {
        System.out.printf("Buch: %s\nPreis: %,2f\nSpielzeit: %s\n", super.getBezeichnung(), getPreis(), spielzeit);
    }

}
