package com.example.dat367_projekt_11.models;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private final FirebaseAuth mAuth;
    private String householdName;
    HashMap<String, Profile> profileList = new HashMap<String, Profile>();
    private String password;
    private String email;
    private final ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false


    public User(String email, String password, String householdName) {
        this.password = password;
        this.email = email;
        this.householdName = householdName;
        this.mAuth = FirebaseAuth.getInstance();
        this.householdChores = new ArrayList<Chore>();
    }

    public FirebaseAuth getmAuth(){
        return  mAuth;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewChoreToList(String name, String description, int points){
        Chore chore = new Chore(name, description, points);
        householdChores.add(chore);
    }

    public void removeCompletedChore(Chore chore){
        if (chore.isComplete()){
            householdChores.remove(chore);
        }
    }
    public List<Chore> getHouseholdChores() {
        return householdChores;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public HashMap<String, Profile> getProfileList() {
        return profileList;
    }

    public void addProfile(String name, Profile profile){
        profileList.put(name, profile);
    }

    public void deleteProfile(String profileName){
        profileList.remove(profileName);
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public void setCurrentProfile(Profile profile) {
    }
}