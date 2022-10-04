package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.models.Household;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private final Household household;

    public LoginViewModelFactory(Household household) {
        this.household = household;
    }

    /*public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(user);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }*/
}
