package com;

import java.util.Arrays;

public class Potion {
    public final Ingredient[] ingredients;
    private int stirred = 0;

    public Potion() {
        ingredients = new Ingredient[0];
    }

    public Potion(Ingredient... ingredients) {
        int length = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] != null) length++;
        }
        this.ingredients = new Ingredient[length];
        int sub = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] != null) {
                this.ingredients[i - sub] = ingredients[i];
            } else {
                sub++;
            }
        }
    }

    public boolean isReady() {
        return stirred >= 5 && ingredients.length == 3;
    }

    public void stir() {
        stirred++;
    }

    public int power() {
        if (ingredients.length != 3) return 0;
        int powerSum = 0;
        for (int i = 0; i < ingredients.length; i++) powerSum += ingredients[i].power();
        if (isReady()) powerSum *= 2;
        return powerSum;
    }

    @Override
    public String toString() {
        if (ingredients.length != 3)
            return "Not a magic potion because there are " + ingredients.length + " ingredients instead of 3.";
        StringBuilder sRep = new StringBuilder("Ingredients: ");
        for (int i = 0; i < ingredients.length; i++) {
            sRep.append(ingredients[i]).append(", ");
        }
        if (ingredients.length == 0) {
            sRep.append("None");
        } else {
            sRep.delete(sRep.length() - 2, sRep.length());
        }
        sRep.append("\n");
        sRep.append("Power: ").append(power()).append("\n");
        sRep.append(isReady() ? "yes" : "no");
        return sRep.toString();
    }
}
