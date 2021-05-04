package com.speak;

public class Dog implements Speaker {
    String sound = "Bark";

    Dog(String sound) {
        this.sound = sound;
    }

    Dog() {
    }

    @Override
    public String speak() {
        return sound;
    }
}