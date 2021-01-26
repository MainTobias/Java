package com.euler;

import java.util.Arrays;

public class fifteen {
    private static long x = 20;
    private static long y = 20;
    static long path = 0;
    public static void main(String[] args) {
        long c = getCount(new Position(0, 20), 20);
        System.out.println(c);
    }
    private static long getCount(Position p, long max_x) {
        long count = 0;
        if (p.x == max_x && p.y == 0) {
            path++;
            if (path % 100_000_000 == 0)System.out.println(path);
            return 1;
        } else {
            if (p.x+1<=max_x) {
                count += getCount(new Position(p.x+1, p.y), max_x);
            }
            if (p.y-1>=0) {
                count += getCount(new Position(p.x, p.y-1), max_x);
            }
        }
        return count;
    }

}

class Position{
    long x;
    long y;

    Position(long x, long y) {
        this.x = x;
        this.y = y;
    }
}