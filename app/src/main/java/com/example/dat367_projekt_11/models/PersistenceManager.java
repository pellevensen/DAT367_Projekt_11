package com.example.dat367_projekt_11.models;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PersistenceManager implements FirebasePersistenceManager { //Svårt att testa denna klass, kolla upp mocking

    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;
    private MutableLiveData<String> toastMessage;

    /*private FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = rootRef.collection("users");*/

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public PersistenceManager() {
        this.firebaseAuth = FirebaseAuth.getInstance(); // svårt att testa, kommentarer
        this.userLiveData = new MutableLiveData<>();
        this.loggedOutLiveData = new MutableLiveData<>();
        this.toastMessage = new MutableLiveData<>();

        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
        }
        this.database = FirebaseDatabase.getInstance("https://dat367-projekt-11-default-rtdb.europe-west1.firebasedatabase.app/");
        this.myRef = database.getReference();

    }

    public MutableLiveData<Household> login (String inEmail, String inPassword) {
        MutableLiveData<Household> authenticatedHouseholdMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(inEmail, inPassword).addOnCompleteListener(authTask -> {
            if (authTask.isSuccessful()) {
                boolean isNewUser = authTask.getResult().getAdditionalUserInfo().isNewUser();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    String uid = firebaseUser.getUid();
                    String name = firebaseUser.getDisplayName();
                    String email = firebaseUser.getEmail();
                    Household household = new Household(uid, name, email);
                    household.isNew = isNewUser;
                    authenticatedHouseholdMutableLiveData.setValue(household);
                }
            } else {
                Log.d("LOG", authTask.getException().getMessage());
            }
        });
        return authenticatedHouseholdMutableLiveData;
    }

    public void register(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            toastMessage.setValue("Registration failure "+ task.getException().getMessage());
                        }
                    }
                });
    }

    public void logOut() {
        firebaseAuth.signOut();
        loggedOutLiveData.postValue(true);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }

    public MutableLiveData<Household> createHouseholdInFirestoreIfNotExists(Household authenticatedHousehold) {
        MutableLiveData<Household> newUserMutableLiveData = new MutableLiveData<>();
        /*myRef.child("users").child(authenticatedHousehold.getUid()).setValue(authenticatedHousehold);
        newUserMutableLiveData.setValue(authenticatedHousehold);*/
        return newUserMutableLiveData;
    }

    /*public MutableLiveData<Household> createHouseholdInFirestoreIfNotExists(Household authenticatedHousehold) {
        MutableLiveData<Household> newUserMutableLiveData = new MutableLiveData<>();

        return newUserMutableLiveData;
    }*/
}
