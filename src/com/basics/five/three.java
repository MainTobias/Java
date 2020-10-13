package com.basics.five;

public class three {
    public static void main(String[] args) {
        System.out.println("countLetters(\"\", 'a') = " + countLetters("", 'a'));
        System.out.println("countLetters(\"Mississippi\", 's') = " + countLetters("Mississippi", 's'));
    }
    static int countLetters(String word, char letter){
        int count = 0;
        for (char c : word.toCharArray()){
            if (c == letter) count++;
        }
        return count;
    }
}
