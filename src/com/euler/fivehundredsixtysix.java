package com.euler;
/*
import java.util.ArrayList;
import java.util.List;

public class fivehundredsixtysix {
    public static void main(String[] args) {
        Cake c = new Cake();
        System.out.println(c.slices);
        c.flipNext(80);
        System.out.println(c.slices);
        c.flipNext(80);
        System.out.println(c.slices);
        c.flipNext(180);
        System.out.println(c.slices);
        c.flipNext(40);
        System.out.println(c.slices);
    }
    static long F(int a, int b, int c){
        long minFlips = 0;
        double x = 360.0/a;
        double y = 360.0/b;
        double z = 360.0/Math.sqrt(c);



        return minFlips;
    }

}
class Cake{
    public List<Slice> slices;
    Cake(){
        slices = new ArrayList<>();
        slices.add(new Slice(0.0, 360.0, true));
    }
    public boolean isIcingOnTop(){
        boolean icingIsOnTop = true;
        for (Slice s : slices) {
            if (!s.icingIsOnTop) {
                icingIsOnTop = false;
            }
        }
        return icingIsOnTop;
    }

    private static List<Slice> cut(Slice s, double startDegree, double endDegree){
        List<Slice> slices = new ArrayList<>();
        if (s.startPositionInDegree < startDegree){
            slices.add(new Slice(s.startPositionInDegree, startDegree - s.startPositionInDegree, s.icingIsOnTop));
        }
        if (s.startPositionInDegree + s.degree > endDegree){
            slices.add(new Slice(endDegree, s.startPositionInDegree + s.degree - endDegree, s.icingIsOnTop));
        }



        return slices;
    }

    public void flipNext(double startDegree, double endDegree){
        for (int i = 0; i < slices.size(); i++) {
            if (slices.get(i).startPositionInDegree < endDegree) {
                List<Slice> cutSlices = cut(slices.get(i), startDegree, endDegree);

            }
        }
    }
    public void flipNext(double degree){
        flipNext(currentDegree, currentDegree+degree);
    }
}

class Slice{
    public double degree;
    public double startPositionInDegree;
    public boolean icingIsOnTop;
    Slice(double startPositionInDegree, double degree, boolean icingIsOnTop){
        this.startPositionInDegree = startPositionInDegree % 360;
        this.degree = degree;
        this.icingIsOnTop = icingIsOnTop;
    }
    public void switchIcingOnTop(){
        this.icingIsOnTop = !this.icingIsOnTop;
    }
    static private boolean intersect(double arm, double startDegree, double endDegree){
        if (startDegree > endDegree) {
            if (arm >= startDegree || arm <= endDegree){
                return true;
            }
        } else {
            if (arm >= startDegree && arm <= endDegree){
                return true;
            }
        }
        return false;
    }
    private boolean isIn(double startDegree, double endDegree, boolean partially) {
        boolean a = intersect(this.startPositionInDegree, startDegree, endDegree);
        boolean b = intersect(this.startPositionInDegree+degree, startDegree, endDegree);
        return partially ? a || b : a && b;
    }
    private boolean isIn(double startDegree, double endDegree){
        return isIn(startDegree, endDegree, true);
    }

    @Override
    public String toString() {
        return degree + " " + icingIsOnTop;
    }
}
*/
