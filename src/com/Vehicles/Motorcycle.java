package com.Vehicles;

public class Motorcycle extends Vehicle implements Motorized{
    boolean motorIsRunning;
    double power;
    /**
     * Creates a new motorcycle.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Motorcycle(String brand, int wheels, double power, boolean started) {
        super(brand, wheels);
        motorIsRunning = started;
        setPower(power);
        if (!(wheels == 2 || wheels == 3)) throw new IllegalArgumentException();
    }

    public Motorcycle(String brand, double power) {
        this(brand, 2, power, false);
    }

    public void setPower(double power) {
        if (power < 0) throw new IllegalArgumentException();
        this.power = power;
    }

    @Override
    public void start() {
        motorIsRunning = true;
    }

    @Override
    public void stop() {
        motorIsRunning = false;
    }

    @Override
    public boolean isStarted() {
        return motorIsRunning;
    }

    @Override
    public double getPower() {
        return power;
    }
}
