package com.example.dat367_projekt_11.models;


import java.util.List;

public class Chore{
    private final String name;
    private final String description;
    private final int points;
    private boolean isComplete;
    private List<IListener> listeners;


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

    private void subscibe(IListener listener){
        listeners.add(listener);

    }
    private void notifyObservers() {
        for (IListener listener : listeners) {
            if (this.isComplete()) {
                listener.update(this);
            }
        }
    }







}
