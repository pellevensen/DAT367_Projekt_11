package com.example.dat367_projekt_11.models;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class User implements ChoreStatusListener{ //lyssnar på chores boolean{
    private final FirebaseAuth mAuth;
    private String householdName;
    private List<Profile> profileList;
    private String password;
    private String email;
    private final ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
    private ArrayList<ChoreListStatusListener> listeners;
    //måste vi inte skapa listan av householdchores och listeners någonstans för att kunna lägga till i?
//kolla att sakerna är nollskilda, objekt required non null.
    //design by contract


    public User(String email, String password, String householdName) {
        this.password = password;
        this.email = email;
        this.householdName = householdName;
        this.mAuth = FirebaseAuth.getInstance();
        this.householdChores = new ArrayList<Chore>();
        this.profileList = new ArrayList<>();
    }

    public FirebaseAuth getmAuth(){
        return  mAuth;
    }
    //returnera kopia? orginal kan mixtas med.


    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewChoreToList(String name, String description, int points){ //när en chore skapas, meddelas alla som im. chorelist status listener
       Chore chore = new Chore(name, description, points);
       householdChores.add(chore);
       //notifyListeners(); // --> notifiera mainpageview
    }

    private void removeCompletedChore(Chore chore){ //när en chore tas bort meddelas alla som implementerar choreliststatuslistener
            if (chore.isComplete()){
                householdChores.remove(chore);
                //notifyListeners(); //--> notifiera completeschoreview

        }
    }

    //defensiv inkopiering, defensiv utkopiering -> kan göra så man får en wrapper som gör unmodifiable. blir körningsfel om så händer. läs collectionsklassen.

    public ArrayList<Chore> getHouseholdChores() { //jättemuterbar obs! collections. java utility collections.-> unmodifiable, ex of chores. kan ej modifiera listan
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

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void addProfile(Profile profile){
        profileList.add(profile);
    }

    public void deleteProfile(Profile profile){
        profileList.remove(profile);
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }
    @Override
    public void update(Chore chore) {  //updateras householdchores -> available chores -> lyssnar på chores boolean
        this.removeCompletedChore(chore);

    }


    private void subscribe(ChoreListStatusListener listener) { //broadcast
        listeners.add(listener);
    }

    public void setCurrentProfile(Profile profile) {

    }


    private void notifyListeners() {
        for (ChoreListStatusListener listener : listeners) {  //broadcast
            listener.update(householdChores);
        }

    }

}
