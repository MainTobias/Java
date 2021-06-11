package com.PlayerColors;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Player{
    private String name;
    private int playerID;
    private Color color;
    static private int playerCount;
    static private final Color[] assignedColors = new Color[Color.values().length];

    public Player(String name, int playerID, Color color) {
        this.name = name;
        this.playerID = playerID;
        this.color = color;
        for (int i = 0; i < assignedColors.length; i++) {
            if (Objects.equals(assignedColors[i], color)) {
                throw new IllegalArgumentException("Color " + color + " already assigned!");
            }
            if (i-1 == assignedColors.length) {
                throw new IllegalArgumentException("No more color to assign!");
            }
            if (assignedColors[i] == null) {
                assignedColors[i] = color;
                break;
            }
        }
        playerCount++;
    }

    public int compareTo(@NotNull Player p) {
        return color.compareTo(p.color);
    }

    public String toString() {
        return name + " has a player ID of " + playerID + " and a color of " + color;
    }

    public static void main(String[] args) {
        Player[] players = new Player[10];
        Random r = new Random();
        int i = 0;
        while (i < players.length) {
            try {
                players[i] = new Player("Name",r.nextInt(), Color.values()[r.nextInt(11)]);
                i++;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        String[] s = new String[players.length];
        for (int j = 0; j < s.length; j++) {
            s[j] = players[j].toString();
        }
        System.out.println(String.join("\n", s));
    }
    public static void reset() {
        Arrays.fill(assignedColors, null);
        playerCount = 0;
    }
}
