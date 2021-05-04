package com.speak;

public class Person implements Speaker {
    String sound = "Hello";
    boolean isMute;

    Person(String sound) {
        isMute = Math.random() < 0.05;
        this.sound = sound;
    }

    Person() {
        isMute = Math.random() < 0.05;
    }

    @Override
    public String speak() throws MuteException {
        if (isMute) {
            throw new MuteException(this);
        }
        return sound;
    }
}
