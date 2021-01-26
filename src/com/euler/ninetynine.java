package com.euler;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ninetynine {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\tobia\\Downloads\\base_exp.txt");
        FileReader fr = new FileReader(f);   //reads the file
        BufferedReader br = new BufferedReader(fr);
        String line;
        int lineNum = 1;
        Power biggestPower = new Power(0,0,0);
        while((line=br.readLine())!=null)
        {
            System.out.println(lineNum);
            Power p = new Power(lineNum++, Integer.parseInt(line.split(",")[0].strip()), Integer.parseInt(line.split(",")[1].strip()));
            if (p.result.compareTo(biggestPower.result) == 1) {
                biggestPower = p;
            }
        }
        fr.close();
        System.out.println(biggestPower);
    }
}
class Power{
    public int line;
    public int base;
    public int exponent;
    public BigInteger result;

    Power(int line, int base, int exponent){
        this.line = line;
        this.base = base;
        this.exponent = exponent;
        this.result = calculate(base, exponent);
    }
    static private BigInteger calculate(int base, int exponent){
        return BigInteger.valueOf(base).pow(exponent);
    }

    @Override
    public String toString() {
        return "Line: " + this.line + "\nBase:" + this.base + "\nExponent: " + this.exponent + "\nResult: " + new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT)).format(this.result);
    }
}