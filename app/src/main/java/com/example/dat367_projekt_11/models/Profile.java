package com.example.dat367_projekt_11.models;


import java.util.ArrayList;


public class Profile implements ChoreStatusListener {
    private String name;
    private int currentPoints = 0;
    private ArrayList<Chore> doneChores;
    private ArrayList<ChoreListStatusListener> listeners;


    public Profile(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }


    private void addChoretoCompletedChore(Chore chore){
        doneChores.add(chore);
    }

    private void addPointToCurrentPoints(Chore chore){
        this.currentPoints += chore.getPoints();
    }


    public ArrayList<Chore> getDoneChores(){
        return this.doneChores;
    }


    @Override
    public void update(Chore chore) {
        addPointToCurrentPoints(chore);
        addChoretoCompletedChore(chore);
        notifyListeners();
    }

    private void notifyListeners() {
        for(ChoreListStatusListener listener : listeners){
            listener.update(doneChores);
        }
    }
    private void subscribe(ChoreListStatusListener listener) {
        listeners.add(listener);
    }

    public void setName(String name){
        this.name = name;
    }

}