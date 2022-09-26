package com.example.dat367_projekt_11.models;

import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class Profile {
    private FirebaseUser user;
    private EditText profileName; //tror att det ska vara bara string eftersom EditText är visuell klass
    private int points;
    private List<Chore> completedChores;

    public Profile(FirebaseUser user, EditText profileName, int points, List<Chore> completedChores) {
        this.user = user;
        this.profileName = profileName;
        this.points = points;
        this.completedChores = completedChores;
    }

    public EditText getName() {
        return profileName;
    }
    public void completeChore(Chore chore){
        chore.completeChore();
        completedChores.add(chore);
    }

}
