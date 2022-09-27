package com.example.dat367_projekt_11.models;

import java.util.HashMap;
import java.util.List;

public class User {
    private String householdName;
    HashMap<String, Profile> profileList = new HashMap<String, Profile>();
    private String password;
    private String email;
    private List<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false


    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewChoreToList(String name, String description, int points){
       Chore chore = new Chore(name, description, points);
       householdChores.add(chore);
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

    public void addProfile(String name){
        profileList.put(name, new Profile(name));
    }

    public void deleteProfile(String profileName){
        profileList.remove(profileName);
    }

}
