package com.example.dat367_projekt_11.models;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Household implements Serializable { //lyssnar på chores boolean{
    private String householdName;
    private List<Profile> profileList;
    private String password;
    private String email;

    public String getUid() {
        return uid;
    }

    private String uid;
    private final ArrayList<Chore> householdChores; //ev. hashmap, bara chores med is.complete = false
    private ArrayList<ChoreListStatusListener> listeners;
    //måste vi inte skapa listan av householdchores och listeners någonstans för att kunna lägga till i?
//kolla att sakerna är nollskilda, objekt required non null.
    //design by contract


    public Household(String uid, String email, String householdName) {
        this.uid = uid;
        this.email = email;
        this.householdName = householdName;
        this.householdChores = new ArrayList<Chore>();
        this.profileList = new ArrayList<>();

        /*mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    currentUser = firebaseAuth.getCurrentUser();
                }else{
                    currentUser = null;
                }
            }
        });*/
    }

   /* public FirebaseAuth getmAuth(){
        return  mAuth;
    }
    //returnera kopia? orginal kan mixtas med.*/

    @Exclude
    public boolean isNew, isCreated;

    @Exclude
    public boolean isAuthenticated;

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
   /* @Override
    public void update(Chore chore) {  //updateras householdchores -> available chores -> lyssnar på chores boolean
        this.removeCompletedChore(chore);

    }*/


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
