package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person {
    private String vorname;
    private String nachname;

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setNachname("Lothar");
        p1.setVorname("Friedl");
        System.out.println("Vorname: " + p1.getVorname());
        System.out.println("Name: " + p1.getNachname());
        Person p2 = new Person("Klammer", "Franz");
        System.out.println(p2); // Ausgabe : " Klammer Franz "
    }

    Person(String nachname, String vorname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    Person() {

    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return nachname + " " + vorname;
    }
}

class Konto2 {
    private double kontostand;
    private Person inhaber;

    public static void main(String[] args) {
        Konto2 konto1 = new Konto2("Schmidt", "Hans", 500.0);
        Konto2 konto2 = new Konto2("Krause", "Peter", 1500.0);
        Konto2 konto3 = new Konto2("Bauer", "Harald", 500.0);
        Konto2.vergleich(konto1, konto2);
        Konto2.vergleich(konto2, konto3);
        Konto2.vergleich(konto1, konto3);
    }

    Konto2(String nachname, String vorname, double geld) {
        inhaber = new Person(nachname, vorname);
        kontostand = geld;
    }

    public static void vergleich(Konto2 k1, Konto2 k2) {
        if (k1.kontostand == k2.kontostand) {
            System.out.printf("%s und %s haben den gleichen Kontostand.\n", k1.inhaber.getNachname(), k2.inhaber.getNachname());
        } else {
            System.out.printf((k1.kontostand > k2.kontostand ? "%s" : "%2$s") + " hat mehr Geld auf dem Konto als %s\n", k1.inhaber.getNachname(), k2.inhaber.getNachname());
        }
    }
}

class Student extends Person {
    private int matrikelnummer;

    public static void main(String[] args) {
        String[] vn = {"Alfred", "Bernd", "Carola", "Dieter", "Erich",
                "Gerda", "Hans", "Jochen", "Karin", "Maike"};
        String[] nn = {"Adler", "Baron", "Claus", "Dimov", "Eliot",
                "Gatti", "Heine", "Jahn", "Kozak", "Miller"};
        int[] mn = {12345, 45671, 23456, 11111, 45667,
                98712, 23456, 65123, 12634, 22222};
        Student[] students = new Student[vn.length];
        for (int i = 0; i < vn.length; i++) {
            students[i] = new Student(nn[i], vn[i], mn[i]);
        }

        print(filterNachname(students, "a"));
    }

    Student(String nachname, String vorname, int matrikelnummer) {
        super(nachname, vorname);
        if (matrikelnummer < 0) {
            throw new IllegalArgumentException("Martikelnummmer muss größer gleich 0 sein.");
        }
        this.matrikelnummer = matrikelnummer;
    }

    public static Student[] filterNachname(Student[] students, String pattern) {
        Student[] copy = students.clone();
        int lminus = 0;
        for (int i = 0; i < copy.length; i++) {
            if(copy[i].getNachname().contains(pattern)) {
                copy[i] = null;
                lminus++;
            }
        }
        Student[] filtered = new Student[copy.length - lminus];
        int x = 0;
        for (int i = 0; i < copy.length; i++) {
            if (!(copy[i] == null)) {
                filtered[x] = copy[i];
                x++;
            }
        }
        return filtered;
    }

    public static void print(Student[] students) {
        String format = "| %-11s | %-12s | %-15s |%n";

        System.out.format("+-------------+--------------+-----------------+%n");
        System.out.format("| Vorname     | Nachname     | Matrikelnmr     |%n");
        System.out.format("+-------------+--------------+-----------------+%n");
        for (int i = 0; i < students.length; i++) {
            System.out.format(format, students[i].getVorname(), students[i].getNachname(), students[i].matrikelnummer);
        }
        System.out.format("+-------------+--------------+-----------------+%n");

    }

    @Override
    public String toString() {
        return super.toString() + " " + matrikelnummer;
    }
}






/*
*Old impl
import java.time.LocalDate;

public class Person {
    public static void main(String args[]) {
        Person p = new Person(); // name = vorname = "N.N." , geb = 0
        Person p1 = new Person(2000); // name = vorname = "N.N."
        Person p2 = new Person(" Maier ", 1998); // vorname = "N.N."
        Person p3 = new Person(" Schmidt ", " Franz ", 1998);
        p1.setZuname(" Bauer ");
        p1.setVorname(" Hans ");
        p2.setVorname(" Eva");
        System.out.println(p1 + " ist " + p1.getAlter() + " Jahre alt.");
        if (p2.gleichAlt(p3)) { // Instanzmethode gleichAlt ()
            System.out.println(p2 + " und " + p3 + " sind gleich alt.");
        }
        if (Person.gleichAlt(p2, p3)) { // Klassenmethode gleichAlt ()
            System.out.println(p2 + " und " + p3 + " sind gleich alt.");
        }
    }

    private String vorname;
    private String zuname;
    private int geburtsjahr;

    Person() {
        this("N.N.", "N.N.", 0);
    }

    Person(int geburtsjahr) {
        this("N.N.", "N.N.", geburtsjahr);
    }

    Person(String zuname, int geburtsjahr) {
        this(zuname, "N.N.", geburtsjahr);
    }

    Person(String zuname, String vorname, int geburtsjahr) {
        this.setGeburtsjahr(geburtsjahr);
        this.setVorname(vorname);
        this.setZuname(zuname);
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public int getAlter() {
        return LocalDate.now().getYear() - geburtsjahr;
    }

    private void setGeburtsjahr(int geburtsjahr) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        if (geburtsjahr > 0 && geburtsjahr <= year) {

        }
        this.geburtsjahr = geburtsjahr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getZuname() {
        return zuname;
    }

    public void setZuname(String zuname) {
        this.zuname = zuname;
    }

    public boolean gleichAlt(Person p1) {
        return p1.getGeburtsjahr() == this.getGeburtsjahr();
    }

    public static boolean gleichAlt(Person p1, Person p2) {
        return p1.getGeburtsjahr() == p2.getGeburtsjahr();
    }

    @Override
    public String toString() {
        return getZuname() + getVorname();
    }
}
*/