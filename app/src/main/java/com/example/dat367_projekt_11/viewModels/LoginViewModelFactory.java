package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.models.User;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private final User user;

    public LoginViewModelFactory(User user) {
        this.user = user;
    }

    /*public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(user);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }*/
}
