package com.example.dat367_projekt_11.models;


import java.util.ArrayList;


public class Profile implements ChoreStatusListener {
    private final String name;
    private int currentPoints = 0;
    private ArrayList<Chore> doneChores;
    private ArrayList<ChoreListStatusListener> listeners;
    //konstruktorparametrar för donechores och listeners?

    public Profile(String name, ArrayList<Chore> doneChores, ArrayList<ChoreListStatusListener> listeners) {
        this.name = name;
        this.doneChores = doneChores;
        this.listeners = listeners;
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

}