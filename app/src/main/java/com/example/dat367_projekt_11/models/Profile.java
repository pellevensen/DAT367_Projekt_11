package com.example.dat367_projekt_11.models;

public class Profile {
    private String name;
    private int currentPoints;

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setName(String name) {
        this.name = name;
    }
}
