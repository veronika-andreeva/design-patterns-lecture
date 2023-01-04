package com.epam;

public class ETADemo {

    public static void main(String[] args) {

        float distance = 500;
        //Create a piece that moves like a Bishop. Use the MoveLikeBishop strategy.
        PreferredTransport car =  new PreferredTransport(new CarStrategy());
        System.out.println("ETA by car " + Float.toString(car.calculateETA(distance)));

        PreferredTransport walking =  new PreferredTransport(new WalkingStrategy());
        System.out.println("ETA by walking " + Float.toString(walking.calculateETA(distance)));

        PreferredTransport publicTransport =  new PreferredTransport(new PublicTransportStrategy());
        System.out.println("ETA by publicTransport " + Float.toString(publicTransport.calculateETA(distance)));
    }



}
