package com.epam;

public class CarStrategy extends TransportStrategy {

    private static final float CAR_VELOCITY = 50;

    @Override
    public float calculateETA(float distance) {
        System.out.println("Calculating ETA by car.");

        return distance / CAR_VELOCITY;
    }
}
