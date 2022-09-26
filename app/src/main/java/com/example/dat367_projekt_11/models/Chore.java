package com.example.dat367_projekt_11.models;

public class Chore {
    private final String name;
    private final String description;
    private final int points;
    public Boolean isComplete;

    public Chore(String name, String description, int points){
        this.name = name;
        this.description = description;
        this.points = points;
    }

    public void completeChore(){
        this.isComplete = true;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }


    public int getPoints(){
        return this.points;
    }
    public boolean isComplete(){
        return this.isComplete;
    }

}
