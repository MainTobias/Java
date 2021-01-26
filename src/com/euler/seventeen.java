package com.euler;
//wtf
//wtf
//wtf
//wtf
//wtf
//wtf
//wtf
//wtf
//wtf
public class seventeen {
    public static void main(String[] args) {
        System.out.println(3527 % 100);
    }
    private static int getLength(int n){
        int sum = 0;
        if (n/100%10==1||n/100%10==2||n/100%10==6) {
            sum += 10;
        }
        if (n/100%10==4||n/100%10==5||n/100%10==9) {
            sum += 11;
        }
        if (n/100%10==3||n/100%10==7||n/100%10==8) {
            sum += 12;
        }
        if (n%10==1||n%10==2||n%10==6) {
            sum += 10;
        }
        return sum;
    }
}
