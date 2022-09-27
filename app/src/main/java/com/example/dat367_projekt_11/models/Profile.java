package com.example.dat367_projekt_11.models;


import java.util.List;

public class Profile {
    private final String name;
    private int currentPoints;
    private List<Chore> doneChores;//delmängd av alla householdChores



    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }
    public void completeChore(Chore chore){
        addChoretoCompletedChore(chore);
        addPointToCurrentPoints(chore);

       // chore.completeChore();
      // doneChores.add(chore);
    }

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