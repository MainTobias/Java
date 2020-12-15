package com.euler;

public class four {
    public static void main(String[] args) {
        System.out.println(getLargestPalindromeFromProducts(3));
    }
    static long getLargestPalindromeFromProducts(int length){
        long curPalindrome = 1;
        long curNum;
        int max;
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            temp.append(9);
        }
        max = Integer.parseInt(temp.toString());
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < max; j++) {
                curNum = i*j;
                if(isPalindrome(curNum)){
                    if(curPalindrome <= curNum) curPalindrome = curNum;
                }
            }
        }
        return curPalindrome;
    }

    private static boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        return s.substring(0, s.length()/2).equals(new StringBuilder(s.substring(s.length()/2)).reverse().toString());
    }
}
