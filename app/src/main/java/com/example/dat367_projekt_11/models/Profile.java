package com.example.dat367_projekt_11.models;


import java.util.List;

public class Profile {
    private String name;
    private int currentPoints;
    private List<Chore> doneChores;//delmängd av alla householdChores bara chores med complete = true,

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void completeCurrentChore(Chore chore){
        chore.completeChore();
        addChoretoCompletedChore(chore);
        addPointToCurrentPoints(chore);
    }
    //istället för att hämta ut från individuell chore, hämta listan.

    private void addPointToCurrentPoints(Chore chore){
        this.currentPoints += chore.getPoints();
    }

    private void addChoretoCompletedChore(Chore chore){
        doneChores.add(chore);
    }


    public List<Chore> getDoneChores(){
        return this.doneChores;
    }


}