package com.example.dat367_projekt_11.models;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class User {
    private String householdName;
    private List<Profile> profileList;
    private String password;
    private String email;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    public User(String email, String password, String householdName) {
        this.password = password;
        this.email = email;
        this.householdName = householdName;
        this.mAuth = FirebaseAuth.getInstance();
        this.firebaseUser = mAuth.getCurrentUser();
    }

    public FirebaseAuth getmAuth(){
        return  mAuth;
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
    public void addProfile(Profile profile){
        profileList.add(profile);
    }


}
