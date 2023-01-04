package com.epam;

public class PreferredTransport {

    private String name;
    private int value;
    private TransportStrategy transportStrategy;

    public PreferredTransport(TransportStrategy transportStrategy) {
        this.transportStrategy = transportStrategy;
    }

    public float calculateETA(float distance) {
        return transportStrategy.calculateETA(distance);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
