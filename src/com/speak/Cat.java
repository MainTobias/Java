package com.speak;

public class Cat implements Speaker {
    String sound = "Meow";

    Cat(String sound) {
        this.sound = sound;
    }

    Cat() {
    }

    @Override
    public String speak() {
        return sound;
    }
}