package com.epam;

public class WalkingStrategy extends TransportStrategy {

    private static final float WALKING_VELOCITY = 5;

    @Override
    public float calculateETA(float distance) {
        System.out.println("Calculating ETA by walking.");

        return distance / WALKING_VELOCITY;
    }
}
