package com.euler;

public class Counter {
    public long original;
    public short _0 = 0;
    public short _1 = 0;
    public short _2 = 0;
    public short _3 = 0;
    public short _4 = 0;
    public short _5 = 0;
    public short _6 = 0;
    public short _7 = 0;
    public short _8 = 0;
    public short _9 = 0;

    Counter(long n) {
        original = n;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                    _0++;
                    break;
                case '1':
                    _1++;
                    break;
                case '2':
                    _2++;
                    break;
                case '3':
                    _3++;
                    break;
                case '4':
                    _4++;
                    break;
                case '5':
                    _5++;
                    break;
                case '6':
                    _6++;
                    break;
                case '7':
                    _7++;
                    break;
                case '8':
                    _8++;
                    break;
                case '9':
                    _9++;
                    break;
            }
        }
    }

    boolean equals(Counter c) {
        return (c._0 == _0 && c._1 == _1 && c._2 == _2 && c._3 == _3 && c._4 == _4 && c._5 == _5 && c._6 == _6 && c._7 == _7 && c._8 == _8 && c._9 == _9);
    }
}
