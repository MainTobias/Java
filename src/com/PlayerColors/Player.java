package com.PlayerColors;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Player{
    private String name;
    private int playerID;
    private Color color;
    static private int playerCount;
    static private Color[] assignedColors = new Color[Color.values().length];

    public Player(String name, int playerID, Color color) {
        this.name = name;
        this.playerID = playerID;
        this.color = color;
        playerCount++;
        for (int i = 0; i < assignedColors.length; i++) {
            if (assignedColors[i] == null) {
                assignedColors[i] = color;
            }
        }
    }

    public int compareTo(@NotNull Player p) {
        return color.compareTo(p.color);
    }

    public static void main(String[] args) {

    }
}
