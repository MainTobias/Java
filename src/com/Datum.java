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
        if (dates.length != 3) throw new IllegalArgumentException();
        tag = dates[0];
        monat = dates[1];
        jahr = dates[2];
        if (!(monat >= 1 && monat <= 12 && tag >= 1 && tag <= daysIn(monat, isSchaltjahr(jahr)))) {
            throw new IllegalArgumentException();
        }
        if (jahr < 1900) throw new IllegalArgumentException();
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

    /**
     * Erzeugt eine Datumsinstanz, die t Tage nach dem 1.1.1900 liegt.
     *
     * @param tage die Tage seit dem 1.1.1900; muss >= 0 sein
     */

    public Datum(int tage) {
        tag = 1;
        monat = 1;
        jahr = 1900;
        if (tage < 0) throw new IllegalArgumentException();
        addiereTage(tage);
    }

    /**
     * Erzeugt eine Datumsinstanz mit den gegebenen Werten.
     *
     * @param tag   der Tag 1-31 ( abhaengig vom Monat)
     * @param monat das Monat, 1 - 12
     * @param jahr  das Jahr, 1900 - 3000
     */
    public Datum(int tag, int monat, int jahr) {
        if (!(tag >= 1 && tag <= daysIn(monat, isSchaltjahr(jahr)) && monat >= 1 && monat <= 12)) {
            throw new IllegalArgumentException();
        }
        if (jahr < 1900) throw new IllegalArgumentException();
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
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
        int tage = 0;
        boolean switched = false;
        if (d1.compareTo(d2) == 0) {
            return 0;
        }
        if (d1.compareTo(d2) == 1) {
            switched = true;
            Datum dTemp = d1;
            d1 = d2;
            d2 = dTemp;
        }
        //while d1 < d2
        while (d1.compareTo(d2) == -1) {
            tage++;
            d1.tag++;
            if (d1.tag > daysIn(d1.monat, isSchaltjahr(d1.jahr))) {
                d1.tag = 1;
                d1.monat++;
                if (d1.monat == 13) {
                    d1.jahr++;
                    d1.monat = 1;
                }
            }
        }
        return switched ? -tage : tage;
    }

    /**
     * Prüft auf Schaltjahr.
     *
     * @param jahr die zu prüfende Jahreszahl
     * @return <code>true</code>, wenn <code>jahr</code> ein Schaltjahr ist, <code>false</code> sonst
     */
    public static boolean isSchaltjahr(int jahr) {
        if (jahr % 4 != 0) {
            return false;
        } else if (jahr % 400 == 0) {
            return true;
        } else if (jahr % 100 == 0) {
            return false;
        } else {
            return true;
        }
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
        return switch (this.monat) {
            case 1 -> "Januar";
            case 2 -> "Februar";
            case 3 -> "März";
            case 4 -> "April";
            case 5 -> "Mai";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Dezember";
            default -> null;
        };
    }

    /**
     * Erhöht (vermindert) das gespeicherte Datum. Liegt nach dieser
     * Operation das Datum vor dem 1.1.1900,
     * so wird eine IllegalArgumentException geworfen und keine Änderung durchgeführt.
     *
     * @param t die Tage, um die dieses Datum erhöht (t > 0) bzw. vermindert (t < 0) wird
     */
    public void addiereTage(int t) {
        if (t < 0) {
            Datum d = new Datum(-t);
            if (d.equals(this)) {
                tag = 1;
                monat = 1;
                jahr = 1900;
            } else {
                throw new IllegalArgumentException();
            }
        }

        while (t > 0) {
            tag++;
            t--;
            if (tag > daysIn(monat, isSchaltjahr(jahr))) {
                tag = 1;
                monat++;
                if (monat == 13) {
                    jahr++;
                    monat = 1;
                }
            }
        }
    }

    /**
     * Liefert die Nummer des Wochentages.
     *
     * @return die Nummer des Wochentages im Bereich von 0(Montag) bis 6(Sonntag)
     */
    public int wochentagNummer() {
        int a = jahr - 1;
        return (a + a / 4 - a / 100 + a / 400 + tageZwischen(new Datum(1, 1, jahr), this)) % 7;
    }

    /**
     * Liefert den Wochentag als String.
     *
     * @return den Wochentag als String
     */
    public String wochentag() {
        return switch (wochentagNummer()) {
            case 0 -> "Montag";
            case 1 -> "Dienstag";
            case 2 -> "Mittwoch";
            case 3 -> "Donnerstag";
            case 4 -> "Freitag";
            case 5 -> "Samstag";
            case 6 -> "Sonntag";
            default -> null;
        };
    }

    /**
     * Vergleicht das <code>this</code>-Datum mit dem übergebenen.
     *
     * @param d das Datum, mit dem verglichen wird
     * @return eine negative Zahl, wenn d spaeter liegt, positiv, wenn d frueher l i egt und
     * 0 bei gleichem Datum
     */
    public int compareTo(Datum d) {
        if (d.tag == tag && d.monat == monat && d.jahr == jahr) {
            return 0;
        }
        if ((jahr > d.jahr) || (jahr == d.jahr && monat > d.monat) || (jahr == d.jahr && monat == d.monat && tag > d.tag)) {
            return 1;
        }
        return -1;
    }

    /**
     * Liefert eine Stringdarstellung i n der Form <code>tt.mm.jjjj</code>
     *
     * @return Stringdarstellung i n der Form <code>tt.mm.jjjj</code>QA QA
     * @override
     */
    @Override
    public String toString() {
        return toString(Datum.FORMAT_NORMAL);
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
        if (!(format >= 0 && format <= 3)) throw new IllegalArgumentException();
        return switch (format) {
            case Datum.FORMAT_SHORT -> String.format("%d.%02d.%02d", tag, monat, jahr % 100);
            case Datum.FORMAT_NORMAL -> String.format("%02d.%02d.%d", tag, monat, jahr);
            case Datum.FORMAT_LONG -> String.format("%d.%s %d, %s", tag, getMonatAsString(), jahr, wochentag());
            case Datum.FORMAT_US -> String.format("%d/%02d/%02d", jahr, tag, monat);
            default -> null;
        };
    }
}
