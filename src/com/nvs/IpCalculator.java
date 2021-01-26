package com.nvs;

public class IpCalculator {
    private String ipv4;
    private int maskBits;
    private String netmask;
    IpCalculator(String ipv4, int maskBits){
        this.ipv4 = ipv4;
        this.maskBits = maskBits;

    }
    public static void main(String[] args) {
        IpCalculator ip = new IpCalculator("192.168.10.2", 24);
        System.out.println("IP Address:   " + ip.getAddress(false) + "   " + ip.getAddress(true));
        System.out.println("Netmask:      " + ip.getNetmask(false) + "   " + ip.getNetmask(true));
        System.out.println("Network:      " + ip.getNetwork(false) + "   " + ip.getNetwork(true));
        System.out.println("Broadcast:    " + ip.getBroadcast(false) + "   " + ip.getBroadcast(true));
        System.out.println("Last host:    " + ip.getLastHost(false) + "   " + ip.getLastHost(true));
        System.out.println("First host:    " + ip.getFirstHost(false) + "   " + ip.getFirstHost(true));
    }

    private String getFirstHost(boolean inBinary) {
        String[] network = getNetwork(inBinary).split("\\.");
        return new StringBuilder(network[0]+".").append(network[1]+".").append(network[2]+".").append(inBinary ? Integer.toBinaryString(Integer.parseInt(network[3], 2)+1) : Integer.parseInt(network[3])+1).toString();
    }

    public String getAddress(boolean inBinary) {
        StringBuilder address = new StringBuilder();
        if (inBinary) {
            for (String s : ipv4.split("\\.")) {
                String bin = Integer.toBinaryString(Integer.parseInt(s));
                address.append("00000000".substring(bin.length())).append(bin).append(".");
            }
            address.delete(address.length()-1, address.length());
        } else {
            address.append(ipv4);
        }
        return address.toString();
    }

    public String getNetmask(boolean inBinary) {
        int maskBitsTemp = maskBits;
        StringBuilder convertedMaskBits = new StringBuilder();
        StringBuilder out = new StringBuilder();
        while (convertedMaskBits.length() < 4) {
            if (maskBitsTemp >= 8) {
                convertedMaskBits.append(8);
                maskBitsTemp -= 8;
            } else {
                convertedMaskBits.append(maskBitsTemp);
                maskBitsTemp = 0;
            }
        }
        if (maskBitsTemp != 0) {
            System.out.println("Fehler Maskbits falsch!");
            System.exit(-1);
        }
        for (int i = 0; i < 4; i++) {
            out.append(Integer.parseInt(repeat('1', convertedMaskBits.charAt(i)-48) + "00000000".substring(convertedMaskBits.charAt(i)-48),2)).append(".");
        }
        out.delete(out.length()-1, out.length());
        if (inBinary) {
            StringBuilder binaryOut = new StringBuilder();
            for (String s : out.toString().split("\\.")) {
                String bin = Integer.toBinaryString(Integer.parseInt(s));
                binaryOut.append("00000000".substring(bin.length())).append(bin).append(".");
            }
            binaryOut.delete(binaryOut.length()-1, binaryOut.length());
            return binaryOut.toString();
        }
        return out.toString();
    }
    public String getNetwork(boolean inBinary){
        String[] res = this.getAddress(inBinary).split("\\.");
        if (inBinary) {
            res[3] = "00000000";
        } else {
            res[3] = "0";
        }
        return String.join(".", res);
    }

    public String getLastHost(boolean inBinary) {
        String[] broadcast = getBroadcast(inBinary).split("\\.");
        return new StringBuilder(broadcast[0]+".").append(broadcast[1]+".").append(broadcast[2]+".").append(inBinary ? Integer.toBinaryString(Integer.parseInt(broadcast[3], 2)-1) : Integer.parseInt(broadcast[3])-1).toString();
    }

    public String getBroadcast(boolean inBinary){
        StringBuilder out = new StringBuilder();
        String netmask = this.getNetmask(false);
        for (int i = 0; i < 4; i++) {
            if(Integer.parseInt(netmask.split("\\.")[i]) == 255) {
                out.append(ipv4.split("\\.")[i]);
            } else if (Integer.parseInt(netmask.split("\\.")[i]) == 0) {
                out.append(255);
            } else {
                double x = 256 - Integer.parseInt(netmask.split("\\.")[i]);
                out.append((int)Math.ceil(Integer.parseInt(ipv4.split("\\.")[i]) / x) * x - 1);
            }
            out.append(".");
        }
        out.delete(out.length()-1, out.length());
        if (out.toString().split("\\.").length > 4){
            StringBuilder finalOut = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                finalOut.append(out.toString().split("\\.")[i]).append(".");
            }
            return out.delete(out.length()-2, out.length()).toString();
        }
        if (inBinary) {
            StringBuilder binaryOut = new StringBuilder();
            for (String s : out.toString().split("\\.")) {
                String bin = Integer.toBinaryString(Integer.parseInt(s));
                binaryOut.append("00000000".substring(bin.length())).append(bin).append(".");
            }
            binaryOut.delete(binaryOut.length()-1, binaryOut.length());
            return binaryOut.toString();
        }
        return out.toString();
    }

    public static String repeat(char c, int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(c);
        }
        return out.toString();
    }
}
