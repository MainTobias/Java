package com;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Bruch {
    long numerator;
    long denominator;
    private static boolean bruchFormat = true;

    public Bruch() {
        this(0, 1);
    } // 0/1

    public Bruch(long z) {
        this(z, 1);
    } // z/1

    public Bruch(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein!");
        }
        if (denominator < 0) {
            this.denominator = -denominator;
            this.numerator = -numerator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        this.simplify();
    }

    public Bruch(String fraction) {
        if (fraction.charAt(fraction.length()-1) == '.') {
            throw new IllegalArgumentException();
        }
        try {
            Bruch b = new Bruch(Double.parseDouble(fraction));
            numerator = b.numerator;
            denominator = b.denominator;
        } catch (Exception e) {
            String[] split = fraction.split("/");
            System.out.println(Arrays.toString(split));
            if (split.length == 1 || split[1].contains("+") || split[1].contains("-") || split[1].equals("0")) {
                throw new IllegalArgumentException();
            }
            numerator = Long.parseLong(split[0]);
            denominator = Long.parseLong(split[1]);
            simplify();
        }
    }

    public Bruch(double value) {
        String[] split = String.valueOf(value).replaceFirst("^0+(?!$)", "").split("\\.");
        String newNom = split[0] + split[1];
        newNom = newNom.replaceFirst("^0+(?!$)", "");
        System.out.println(newNom);
        newNom = newNom.substring(0, Math.min(18, newNom.length()));
        denominator = (long) Math.pow(10, newNom.length()-split[0].length());
        numerator = Long.parseLong(newNom);
        System.out.println(numerator + "/" + denominator);
        simplify();
    }

    private void simplify() {
        long div = ggT(numerator, denominator);
        numerator /= div;
        denominator /= div;
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    } // kürzt und macht Nenner positiv

    public static long ggT(long a, long b) {
        if (a == 0 && b == 0) {
            throw new java.lang.IllegalArgumentException("A und b dürfen nicht beide 0 sein!");
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        long ggT = 1;
        a = Math.abs(a);
        b = Math.abs(b);
        for (long i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                ggT = i;
        }
        return ggT;
    }

    public static long kgV(long a, long b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("A und b dürfen nicht beide 0 sein!");
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
        long newNom = numerator * (newDenom/denominator) + b.numerator * (newDenom/b.denominator);
        return new Bruch(newNom, newDenom);
    } // liefert this + b

    public Bruch sub(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = kgV(denominator, b.denominator);
        long newNom = numerator * (newDenom/denominator) - b.numerator * (newDenom/b.denominator);
        return new Bruch(newNom, newDenom);
    } // liefert this - b

    public Bruch mult(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        long newDenom = denominator * b.denominator;
        long newNom = numerator * b.numerator;
        return new Bruch(newNom, newDenom);
    } // liefert this * b

    public Bruch div(Bruch b) {
        if (b == null) throw new IllegalArgumentException("B ist null!");
        if (b.numerator == 0) {
            throw new IllegalArgumentException("Divisor darf nicht 0 sein!");
        }
        long newDenom = denominator * b.numerator;
        long newNom = numerator * b.denominator;
        return new Bruch(newNom, newDenom);
    } // liefert this / b

    public Bruch hoch(int e) {
        if (e < 0 && this.numerator == 0) {
            throw new IllegalArgumentException();
        }
        if (e < 0) {
            long newDenom = (long) Math.pow(numerator, -e);
            long newNom = (long) Math.pow(denominator, -e);
            return new Bruch(newNom, newDenom);
        }
        long newDenom = (long) Math.pow(denominator, e);
        long newNom = (long) Math.pow(numerator, e);
        return new Bruch(newNom, newDenom);
    } // liefert this ^ e

    public void addThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = add(b);
        this.numerator = newBruch.numerator;
        this.denominator = newBruch.denominator;
    } // this += b

    public void subThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = sub(b);
        this.numerator = newBruch.numerator;
        this.denominator = newBruch.denominator;
    } // this -= b

    public void multThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = mult(b);
        this.numerator = newBruch.numerator;
        this.denominator = newBruch.denominator;
    } // this *= b

    public void divThis(Bruch b) {
        if (b == null) return;
        Bruch newBruch = div(b);
        this.numerator = newBruch.numerator;
        this.denominator = newBruch.denominator;
    } // this /= b

    public void hochThis(int e) {
        Bruch newBruch = hoch(e);
        this.numerator = newBruch.numerator;
        this.denominator = newBruch.denominator;
    } // this ^= e
    public static void setBruchFormat(boolean format) {
        Bruch.bruchFormat = format;
    }
    public String toString() {
        if (!bruchFormat) {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            format.setMinimumFractionDigits(3);
            return format.format((double) numerator / denominator);
        }
        return numerator + "/" + denominator;
    }
}
