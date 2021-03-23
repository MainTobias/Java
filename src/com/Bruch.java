package com;

public class Bruch {
    long nominator;
    long denominator;
    private static boolean dezimal = false;

    public Bruch() {
        this(0, 1);
    } // 0/1

    public Bruch(long z) {
        this(z, 1);
    } // z/1

    public Bruch(long nominator, long denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
        if (denominator <= 0) {
            throw new IllegalArgumentException();
        }
        this.simplify();
    }

    public Bruch(String fraction) {
        String[] split = fraction.split("/");
        nominator = Long.parseLong(split[0]);
        denominator = Long.parseLong(split[1]);
        if (denominator <= 0) {
            throw new IllegalArgumentException();
        }
        simplify();
    }

    public Bruch(double value) {
        String[] split = String.valueOf(value).replaceFirst("^0+(?!$)", "").split("\\.");
        String newNom = split[0] + split[1];
        newNom = newNom.replaceFirst("^0+(?!$)", "");
        System.out.println(newNom);
        newNom = newNom.substring(0, Math.min(18, newNom.length()));
        denominator = (long) Math.pow(10, newNom.length()-split[0].length());
        nominator = Long.parseLong(newNom);
        System.out.println(nominator + "/" + denominator);
        simplify();
    }

    private void simplify() {
        long div = ggT(nominator, denominator);
        nominator /= div;
        denominator /= div;
        if (denominator < 0) {
            denominator = -denominator;
            nominator = -nominator;
        }
    } // kürzt und macht Nenner positiv

    public static long ggT(long a, long b) {
        long ggT = 1;
        for (long i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                ggT = i;
        }
        return ggT;
    }

    public static long kgV(long a, long b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Weder a noch b dürfen 0 sein!");
        }
        if (a == 0 || b == 0) {
            return 0;
        }
        long absa = Math.abs(a);
        long absb = Math.abs(b);
        long absHigherNumber = Math.max(absa, absb);
        long absLowerNumber = Math.min(absa, absb);
        long kgV = absHigherNumber;
        while (kgV % absLowerNumber != 0) {
            kgV += absHigherNumber;
        }
        return kgV;

    }
    public Bruch add(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = kgV(denominator, b.denominator);
        long newNom = nominator * (newDenom/denominator) + b.nominator * (newDenom/b.denominator);
        return new Bruch(newNom, newDenom);
    } // liefert this + b

    public Bruch sub(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = kgV(denominator, b.denominator);
        long newNom = nominator * (newDenom/denominator) - b.nominator * (newDenom/b.denominator);
        return new Bruch(newNom, newDenom);
    } // liefert this - b

    public Bruch mult(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = denominator * b.denominator;
        long newNom = nominator * b.nominator;
        return new Bruch(newNom, newDenom);
    } // liefert this * b

    public Bruch div(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = denominator * b.nominator;
        long newNom = nominator * b.denominator;
        return new Bruch(newNom, newDenom);
    } // liefert this / b

    public Bruch hoch(int e) {
        long newDenom = (long) Math.pow(denominator, e);
        long newNom = (long) Math.pow( nominator, e);
        return new Bruch(newNom, newDenom);
    } // liefert this ^ e

    public void addThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = add(b);
        this.nominator = newBruch.nominator;
        this.denominator = newBruch.denominator;
    } // this += b

    public void subThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = sub(b);
        this.nominator = newBruch.nominator;
        this.denominator = newBruch.denominator;
    } // this -= b

    public void multThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = mult(b);
        this.nominator = newBruch.nominator;
        this.denominator = newBruch.denominator;
    } // this *= b

    public void divThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = div(b);
        this.nominator = newBruch.nominator;
        this.denominator = newBruch.denominator;
    } // this /= b

    public void hochThis(int e) {
        Bruch newBruch = hoch(e);
        this.nominator = newBruch.nominator;
        this.denominator = newBruch.denominator;
    } // this ^= e
    public static void setBruchFormat(boolean format) {
        Bruch.dezimal = format;
    }
    public String toString() {
        if (dezimal) {
            return "" + (double) nominator / denominator;
        }
        return nominator + "/" + denominator;
    }
}
