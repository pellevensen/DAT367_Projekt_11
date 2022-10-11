package com.example.dat367_projekt_11.models;


import java.util.ArrayList;

public class Chore{
    private String name;
    private String description;
    private int points;
    private boolean isComplete;
    private ArrayList<IsCompleteListener> listeners;


    public Chore(String name, String description, int points){
        this.name = name;
        this.description = description;
        this.points = points;
        this.isComplete = false;
    }

    public void completeChore(){
        this.isComplete = true;
        //notifySubscribers();
    }
    public void unCompleteChore(){
        this.isComplete = false;
       // notifySubscribers();

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void subscribe(IsCompleteListener listener){
        listeners.add(listener);

    }
    private void notifySubscribers() {
        for (IsCompleteListener listener : listeners) {
                listener.update(this);
        }
    }







}
