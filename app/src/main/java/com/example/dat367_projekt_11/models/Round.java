package com.example.dat367_projekt_11.models;


import java.util.List;

public class Round {
    Household household;
    List<Profile> profiles;

    public Round(Household household) {
        this.household = household;
        profiles = household.getProfileList();


    }

    public void getWinner(){

    }
    public void resetPoints(){
        for(Profile profile : profiles){
            profile.resetScore();
        }
    }
}
