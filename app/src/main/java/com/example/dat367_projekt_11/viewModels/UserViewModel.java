package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Household;

public class UserViewModel extends ViewModel {
    private Household household;

    public void setPassword(String password){
        household.setPassword(password);
    }
    public void setEmail(String email){
        household.setEmail(email);
    }
    public void setHouseholdName(String householdName){
        household.setHouseholdName(householdName);
    }
}
