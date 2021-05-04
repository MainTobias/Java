package com.Vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Vehicle {
    public static final String[] CAR_BRANDS = {"BMW", "Honda", "Suzuki",
            "VW", "Ferrari", "Alfa Romeo", "Mercedes", "Maserati", "Tesla"};
    public static final String[] MOTORCYCLE_BRANDS = {"BMW", "Honda", "Suzuki",
            "Ducati", "Moto Guzzi", "Kawasaki"};
    public static final String[] BICYCLE_BRANDS = {"Bianchi", "Giant", "Trek", "Scott", "Fuji"};
    private static final Random RANDOM = new Random();
    private String brand;
    private int wheels;

    /**
     * Creates a new vehicle.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Vehicle(String brand, int wheels) {
        if (wheels <= 0) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
        this.wheels = wheels;
    }

    /**
     * Counts how many vehicles have a motor in a given array.
     *
     * @param vehicles an array of vehicles
     * @return number of motorized Objects in array
     */
    private static int countMotorized(Vehicle[] vehicles) {
        int count = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Motorized) {
                count++;
            }
        }
        return count;
    }

    /**
     * Filters all cars with running motor from a given array.
     *
     * @param vehicles an array of vehicles
     * @return an array of vehicles containing only Cars with running motor
     */
    private static Vehicle[] getStartedCars(Vehicle[] vehicles) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Motorized && ((Motorized) vehicles[i]).isStarted()) {
                vehicleList.add(vehicles[i]);
            }
        }
        return (Vehicle[]) vehicleList.toArray();
    }

    /**
     * Creates an array of random Vehicles. Type is random, brand is random. If the vehicle has a motor, the power is
     * also randomized.
     *
     * @param n the number of desired Vehicels
     * @return an array of random Vehicles.
     */
    private static Vehicle[] getNRandom(int n) {
        Vehicle[] vehicles = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            int r = RANDOM.nextInt(3);
            if (r == 0) {
                vehicles[i] = new Car(CAR_BRANDS[RANDOM.nextInt(CAR_BRANDS.length)], RANDOM.nextInt());
            } else if (r == 1) {
                vehicles[i] = new Motorcycle(MOTORCYCLE_BRANDS[RANDOM.nextInt(MOTORCYCLE_BRANDS.length)], RANDOM.nextInt());
            } else {
                vehicles[i] = new Bicycle(BICYCLE_BRANDS[RANDOM.nextInt(BICYCLE_BRANDS.length)], RANDOM.nextInt(1) + 2);
            }
        }
        return vehicles;
    }

    public String getBrand() {
        return brand;
    }

    public int getWheels(){
        return wheels;
    }
};