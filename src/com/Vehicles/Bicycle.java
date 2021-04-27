package com.Vehicles;

public class Bicycle extends Vehicle{
    /**
     * Creates a new bicycle.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Bicycle(String brand, int wheels) {
        super(brand, wheels);
        if (!(wheels == 2 || wheels == 3)) throw new IllegalArgumentException();
    }
    public Bicycle(String brand) {
        this(brand, 2);
    }

}
