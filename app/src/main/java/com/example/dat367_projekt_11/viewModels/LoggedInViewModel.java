package com.example.dat367_projekt_11.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat367_projekt_11.models.PersistenceManager;
import com.google.firebase.auth.FirebaseUser;

public class LoggedInViewModel extends AndroidViewModel {
    private PersistenceManager authAppRepository;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    public LoggedInViewModel(@NonNull Application application) {
        super(application);

        authAppRepository = new PersistenceManager(application);
        userLiveData = authAppRepository.getUserLiveData();
        loggedOutLiveData = authAppRepository.getLoggedOutLiveData();
    }

    public void logOut() {
        authAppRepository.logOut();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }
}