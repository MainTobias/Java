package com;

public class Tisch {
    private String material;
    private double durchmesser;
    private int hoehe;
    private boolean rund;

    public static void main(String[] args) {

        Tisch t1;
        Tisch t2;
        Tisch t3;
        t1 = new Tisch("Holz", 60, 60, false);
        t2 = new Tisch("Kunststoff", 100, 65);
        t3 = new Tisch();
        System.out.println("Tisch 1: " + t1);

        t3.setDurchmesser(85.0);
        t3.setHoehe(70);

        String a = "Höhe nicht gleich";
        if (t1.gleichHoch(t2)) a = "Höhe gleich";
        System.out.println(a);
    }

    public Tisch() {
        setMaterial(null);
        setDurchmesser(-1.0);
        setHoehe(-1);
    }
    public Tisch(String material, double durchmesser, int hoehe, boolean rund) {
        setMaterial(material);
        setDurchmesser(durchmesser);
        setHoehe(hoehe);
        setRund(rund);
    }
    public Tisch(String material, double durchmesser, int hoehe) {
        setMaterial(material);
        setDurchmesser(durchmesser);
        setHoehe(hoehe);
        setRund(true);
    }

    public void setRund(boolean rund) {
        this.rund = rund;
    }

    public void setMaterial(String material) {
        this.material = material;
        if (material == null || material.equals("")) this.material = "Alu";
    }

    public void setDurchmesser(double durchmesser) {
        this.durchmesser = durchmesser;
        if (durchmesser < 0) this.durchmesser = 100.0;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
        if (hoehe < 0) this.hoehe = 80;
    }

    public boolean gleichHoch(Tisch t) {
        return hoehe == t.hoehe;
    }

    @Override
    public String toString() {
        return "Material: " + material + ", Durchmesser: " + durchmesser + "cm, Höhe: " + hoehe + "cm" + (rund ? ", rund" : ", eckig");
    }

}
