package com.speak;

public class MuteException extends Exception {
    private Person p;

    public MuteException(Person p, String errorMessage) {
        super(errorMessage);
        this.p = p;
    }

    public MuteException(Person p) {
        super("Person is not able to speak!");
        this.p = p;
    }
}
