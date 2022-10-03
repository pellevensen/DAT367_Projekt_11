package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.User;

public class UserViewModel extends ViewModel {
    private User user;

    public void setPassword(String password){
        user.setPassword(password);
    }
    public void setEmail(String email){
        user.setEmail(email);
    }
    public void setHouseholdName(String householdName){
        user.setHouseholdName(householdName);
    }
}
