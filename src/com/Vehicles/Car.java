package com.Vehicles;

public class Car extends Vehicle implements Motorized{
    boolean motorIsRunning;
    double power;
    /**
     * Creates a new car.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Car(String brand, double power, boolean started) {
        super(brand, 4);
        motorIsRunning = started;
        setPower(power);
    }

    public Car(String brand, double power) {
        this(brand, power, false);
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
