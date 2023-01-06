package com.epam;

public class PublicTransportStrategy extends TransportStrategy {

    private static final float PUBLIC_TRANSPORT_VELOCITY = 30;

    @Override
    public float calculateETA(float distance) {
        System.out.println("Calculating ETA by car.");

        return distance / PUBLIC_TRANSPORT_VELOCITY;
    }
}
