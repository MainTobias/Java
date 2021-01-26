package com;

public class Ingredient {
    private String name;

    public Ingredient() {
        this("");
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int power() {
        return name.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
