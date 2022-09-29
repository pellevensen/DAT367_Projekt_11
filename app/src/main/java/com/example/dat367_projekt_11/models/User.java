package com.example.dat367_projekt_11.models;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
public class User implements ChoreStatusListener{ //lyssnar på chores boolean{
    private final FirebaseAuth mAuth;
    private String householdName;
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
        this.householdName = householdName;
        this.mAuth = FirebaseAuth.getInstance();
        this.householdChores = householdChores;
        this.listeners = listeners;
    }

    public FirebaseAuth getmAuth(){
        return  mAuth;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewChoreToList(String name, String description, int points){ //när en chore skapas, meddelas alla som im. chorelist status listener
       Chore chore = new Chore(name, description, points, new ArrayList<ChoreStatusListener>());
       householdChores.add(chore);
       notifyListeners(); // --> notifiera mainpageview
    }

    private void removeCompletedChore(Chore chore){ //när en chore tas bort meddelas alla som implementerar choreliststatuslistener
            if (chore.isComplete()){
                householdChores.remove(chore);
                notifyListeners(); //--> notifiera completeschoreview

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

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }
    @Override
    public void update(Chore chore) {  //updateras householdchores -> available chores -> lyssnar på chores boolean
        this.removeCompletedChore(chore);

    }


    private void subscribe(ChoreListStatusListener listener){ //broadcast
        listeners.add(listener);

    }


    private void notifyListeners() {
        for (ChoreListStatusListener listener : listeners) {  //broadcast
            listener.update(householdChores);
        }

    }

}
