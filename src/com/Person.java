package com;

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
