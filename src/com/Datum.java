package com;

import java.time.LocalDate;
import java.util.Arrays;

public class Datum {

    public final static int FORMAT_SHORT = 0;
    public final static int FORMAT_NORMAL = 1;
    public final static int FORMAT_LONG = 2;
    public final static int FORMAT_US = 3;

    private int tag = 0;
    private int monat = 0;
    private int jahr = 0;

    /**
     * Erzeugt eine Datumsinstanz mit dem aktuellen Systemdatum.
     */
    public Datum() {
        LocalDate today = LocalDate.now();
        tag = today.getDayOfMonth();
        monat = today.getMonthValue();
        jahr = today.getYear();
    }

    /**
     * Erzeugt eine Datumsinstanz im Format TT.MM.YYYY.
     *
     * @param dateString zu parsender String
     */
    public Datum(String dateString) {
        int[] dates = Arrays.stream(dateString.split("\\.")).mapToInt(Integer::parseInt).toArray();
        tag = dates[0];
        monat = dates[1];
        jahr = dates[2];
        if (!(tag >= 1 && tag <= 31 && monat >= 1 && monat <= 12)) {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Erzeugt eine Datumsinstanz, die t Tage nach dem 1.1.1900 liegt.
     *
     * @param tage die Tage seit dem 1.1.1900; muss >= 0 sein
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
    public static int daysIn(int month, boolean isLeap) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeap ? 29 : 28;
        }
        throw new IllegalArgumentException("Month must be between 1 and 12");
    }

    public Datum(int tage) {
        tag = 1;
        monat = 1;
        jahr = 1900;
        while (tage >= 365) {
            if (isLeapYear(jahr)) {
                if (tage >= 366) {
                    tage -= 366;
                    jahr++;
                } else {
                    break;
                }
            }
            tage -= 365;
            jahr++;
        }
        while (tage >= 28) afasf;
    }

    /**
     * Erzeugt eine Datumsinstanz mit den gegebenen Werten.
     *
     * @param tag   der Tag 1-31 ( abhaengig vom Monat)
     * @param monat das Monat, 1 - 12
     * @param jahr  das Jahr, 1900 - 3000
     */
    public Datum(int tag, int monat, int jahr) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert die zwischen zwei Daten vergangenen Tage.
     *
     * @param d1 das erste Datum
     * @param d2 das zweite Datum
     * @return Tage zwischen <code>d1</code> und <code>d2</code>;
     * positiv wenn <code>d2</code> nach <code>d1</code> liegt, sonst negativ
     */
    public static int tageZwischen(Datum d1, Datum d2) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Prüft auf Schaltjahr.
     *
     * @param jahr die zu prüfende Jahreszahl
     * @return <code>true</code>, wenn <code>jahr</code> ein Schaltjahr ist, <code>false</code> sonst
     */
    public static boolean isSchaltjahr(int jahr) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Datum datum = (Datum) o;
        return tag == datum.tag &&
                monat == datum.monat &&
                jahr == datum.jahr;
    }

    /**
     * Liefert den Namen des Monats.
     *
     * @return den Monatsnamen
     */
    public String getMonatAsString() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Erhöht (vermindert) das gespeicherte Datum. Liegt nach dieser
     * Operation das Datum vor dem 1.1.1900,
     * so wird eine IllegalArgumentException geworfen und keine Änderung durchgeführt.
     *
     * @param t die Tage, um die dieses Datum erhöht (t > 0) bzw. vermindert (t < 0) wird
     */
    public void addiereTage(int t) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert die Nummer des Wochentages.
     *
     * @return die Nummer des Wochentages im Bereich von 0(Montag) bis 6(Sonntag)
     */
    public int wochentagNummer() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert den Wochentag als String.
     *
     * @return den Wochentag als String
     */
    public String wochentag() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Vergleicht das <code>this</code>-Datum mit dem übergebenen.
     *
     * @param d das Datum, mit dem verglichen wird
     * @return eine negative Zahl, wenn d spaeter liegt, positiv, wenn d frueher l i egt und
     * 0 bei gleichem Datum
     */
    public int compareTo(Datum d) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert eine Stringdarstellung i n der Form <code>tt.mm.jjjj</code>
     *
     * @return Stringdarstellung i n der Form <code>tt.mm.jjjj</code>QA QA
     * @override
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert eine Stringdarstellung unterschiedlichen Formats
     *
     * @param format Moegliche Werte sind:
     *               <code>Datum.FORMAT_SHORT, Datum.FORMAT_NORMAL, Datum.FORMAT_LONG, Datum.FORMAT_US</code>
     * @return Datum im Format <code>dd.mm.yy</code> bei <code>Datum.FORMAT_SHORT</code>,
     * im Format <code>dd.monat jjjj, wochentag (Monat ausgeschrieben)</code> bei
     * <code>Datum.FORMAT_LONG</code>, im Format <code>jjjj/tt/mm</code> bei
     * <code>Datum.FORMAT_US</code>
     */
    public String toString(int format) {
        throw new UnsupportedOperationException("TODO");
    }
}
