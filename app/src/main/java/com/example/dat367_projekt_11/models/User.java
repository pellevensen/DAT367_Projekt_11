package com.example.dat367_projekt_11.models;

import android.widget.EditText;

import java.util.List;

public class User {
    private EditText householdName;
    private List<Chore> householdChores;
    private List<Profile> householdProfiles;

    void addChore(Chore chore){householdChores.add(chore);}
    void removeChore(Chore chore){householdChores.remove(chore);}
    void addProfile(Profile profile){householdProfiles.add(profile);}
}
