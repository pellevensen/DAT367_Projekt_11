package com.example.dat367_projekt_11.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User implements ChoreStatusListener{
    private final String householdName;
    HashMap<String, Profile> profileList = new HashMap<String, Profile>();
    private String password;
    private String email;
    private ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
    private ArrayList<ChoreListStatusListener> listeners;
    //måste vi inte skapa listan av householdchores och listeners någonstans för att kunna lägga till i?


    public User(String householdName, String email, String password, ArrayList<Chore> householdChores, ArrayList<ChoreListStatusListener> listeners) {
        this.householdName = householdName;
        this.password = password;
        this.email = email;
        this.householdChores = householdChores;
        this.listeners = listeners;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewChoreToList(String name, String description, int points){
       Chore chore = new Chore(name, description, points);
       householdChores.add(chore);
       notifyListeners();
    }

    private void removeCompletedChore(Chore chore){
            if (chore.isComplete()){
                householdChores.remove(chore);
                notifyListeners();

        }
    }


    public ArrayList<Chore> getHouseholdChores() {
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
        profileList.put(name, new Profile(name, new ArrayList<Chore>(), listeners));
    }

    public void deleteProfile(String profileName){
        profileList.remove(profileName);
    }

    @Override
    public void update(Chore chore) {
        this.removeCompletedChore(chore);

    }


    private void subscibe(ChoreListStatusListener listener){
        listeners.add(listener);

    }


    private void notifyListeners() {
        for (ChoreListStatusListener listener : listeners) {
            listener.update(householdChores);
        }

    }
}
