package com.example.dat367_projekt_11.models;




import java.util.ArrayList;
import java.util.Observer;


public class Chore{
    private String name;
    private String description;
    private int points;
    private boolean isComplete;
    private ArrayList<IsCompleteListener> listeners = new ArrayList<>(); //listan med subscribers


    public Chore(String name, String description, int points){
        this.name = name;
        this.description = description;
        this.points = points;
        this.isComplete = false;
        this.listeners = new ArrayList<>();
    }

    public void completeChore(){
        this.isComplete = true;
        //notifySubscribers();
    }
    public void unCompleteChore(){
        this.isComplete = false;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void subscribe(IsCompleteListener listener){ //lägg till lyssnare
        listeners.add(listener);

    }

    public void unsubscribe(IsCompleteListener listener){
        listeners.remove(listener);
    }

    private void notifySubscribers() {  //notifiera lyssnare
        for (IsCompleteListener listener : listeners) {
                listener.update(this);
        }
    }









}
