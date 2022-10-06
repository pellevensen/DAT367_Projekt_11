package com.example.dat367_projekt_11.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {
    private PersistenceManagerFactory persistenceManagerFactory;

    private MutableLiveData<FirebaseUser> userLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        persistenceManagerFactory = new PersistenceManagerFactory();
        userLiveData = persistenceManagerFactory.getPersistenceManager(application).getUserLiveData();
    }

    public void login(String email, String password) {
        persistenceManagerFactory.getPersistenceManager(getApplication()).login(email, password);
    }

    void createHousehold(Household authenticatedHousehold) {
        userLiveData = persistenceManagerFactory.getPersistenceManager(getApplication()).writeNewHousehold(authenticatedHousehold);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

}