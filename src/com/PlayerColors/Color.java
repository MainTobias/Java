package com.PlayerColors;

public enum Color {
    Blue(new RGBColors(0, 0, 255)),
    Green(new RGBColors(0, 255, 0)),
    Orange("#FF5733"),
    Red(new RGBColors(255, 0, 0)),
    Yellow("#FFB433"),
    LightGreen("#54FF33"),
    DarkBlue("#050951"),
    Rose("#F90BF9"),
    Violet("#530054"),
    StrongRed("#660000"),
    QRX(new RGBColors(255,155,55)),
    ;

    private final RGBColors rgb;

    Color(RGBColors rgbs) {
        this.rgb = rgbs;
    }

    Color(String hex) {
        this(new RGBColors(hex));
    }

    public static void main(String[] args) {
        //Color c = new Color.Blue("#00ff00");
    }
}

class RGBColors {
    private final String hex;
    private final int r;
    private final int g;
    private final int b;

    public RGBColors(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.hex = String.format("#%s%s%s", toHex(Integer.toHexString(r)), toHex(Integer.toHexString(g)), toHex(Integer.toHexString(b)));
        if (this.hex.length() != 7) {
            throw new IllegalArgumentException();
        }
    }

    public RGBColors(String hex) {
        if (hex.length() != 7) {
            throw new IllegalArgumentException();
        }
        this.hex = hex;
        char[] cs = hex.toCharArray();
        this.r = Integer.parseInt(String.valueOf(cs[1]) + String.valueOf(cs[2]), 16);
        this.g = Integer.parseInt(String.valueOf(cs[3]) + String.valueOf(cs[4]), 16);
        this.b = Integer.parseInt(String.valueOf(cs[5]) + String.valueOf(cs[6]), 16);
    }

    private static String toHex(String hex) {
        String s = ("00" + hex);
        return s.substring(s.length()-2);
    }

    @Override
    public String toString() {
        return "RGBColors{" +
                "hex='" + hex + '\'' +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }
    public int compareToo(RGBColors rgb) {
        return Integer.compare(Integer.decode(hex), Integer.decode(rgb.hex));
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public String getHex() {
        return hex;
    }
}
