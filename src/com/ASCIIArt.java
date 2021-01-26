package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ASCIIArt {
    public static void main(String[] args) {
        Scanner fromFile = null;
        System.out.print("Filename: ");
        String filename = new Scanner(System.in).nextLine().strip().replace("\"", "");
        try {
            fromFile = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println(" File not found : " + filename);
            return;
        }
        int width = 0;
        int height = 1;
        if (fromFile.hasNextLine()) {
            width = fromFile.nextLine().length();
        }
        while (fromFile.hasNextLine()) {
            height++;
            String line = fromFile.nextLine();
            if (line.length() != width) {
                System.out.println(filename + " Exception");
                System.exit(-1);
            }
        }
        System.out.println(filename + " ok " + width + " " + height);
        fromFile.close();
    }

}
