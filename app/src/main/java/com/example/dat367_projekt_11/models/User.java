package com.example.dat367_projekt_11.models;

import java.util.List;

public class User {
    private String householdName;
    private List<Profile> profileList;
    private String password;
    private String email;

    public User(String email, String password, String householdName) {
        this.password = password;
        this.email = email;
        this.householdName = householdName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getHouseholdName() {
        return householdName;
    }
    public void setHouseholdName(String householdName){ this.householdName = householdName;}

    public List<Profile> getProfileList() {
        return profileList;
    }
    public void addProfile(String name){
        profileList.add(new Profile(name));
    }

}
