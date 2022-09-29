package com.example.dat367_projekt_11.models;


import java.util.ArrayList;

public class Chore{
    private final String name;
    private final String description;
    private final int points;
    private boolean isComplete;
    private ArrayList<ChoreStatusListener> listeners;


    public Chore(String name, String description, int points, ArrayList<ChoreStatusListener> listeners){
        this.name = name;
        this.description = description;
        this.points = points;
        this.listeners = listeners;
    }

    public void completeChore(){
        this.isComplete = true;
        notifySubscribers();
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

    private void subscribe(ChoreStatusListener listener){
        listeners.add(listener);

    }
    private void notifySubscribers() {
        for (ChoreStatusListener listener : listeners) {
                listener.update(this);
        }
    }







}
