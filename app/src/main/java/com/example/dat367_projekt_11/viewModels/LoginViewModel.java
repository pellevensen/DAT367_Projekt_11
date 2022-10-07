package com.example.dat367_projekt_11.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.models.PersistenceManagerFactory;
import com.example.dat367_projekt_11.models.Profile;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private PersistenceManagerFactory persistenceManagerFactory;
    private MutableLiveData<Household> authenticatedHouseholdLiveData;
    private MutableLiveData<Household> createdHouseholdLiveData;

    public MutableLiveData<List<Profile>> listOfProfile;

    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<String> householdName = new MutableLiveData<>();

    public MutableLiveData<Household> getAuthenticatedHousehold() {
        if (authenticatedHouseholdLiveData == null) {
            authenticatedHouseholdLiveData = new MutableLiveData<Household>();
        }
        return authenticatedHouseholdLiveData;
    }

    public MutableLiveData<Household> getCreatedHousehold() {
        if (createdHouseholdLiveData == null) {
            createdHouseholdLiveData = new MutableLiveData<Household>();
        }
        return createdHouseholdLiveData;
    }

    public MutableLiveData<String> getEmail() {
        if (email == null) {
            email = new MutableLiveData<String>();
        }
        return email;
    }
    public MutableLiveData<String> getPassword() {
        if (password == null) {
            password = new MutableLiveData<String>();
        }
        return password;
    }
    public MutableLiveData<String> getHouseholdName() {
        if (householdName == null) {
            householdName = new MutableLiveData<String>();
        }
        return householdName;
    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
        persistenceManagerFactory = new PersistenceManagerFactory();

    }

    public void login(String email, String password) {
        authenticatedHouseholdLiveData = persistenceManagerFactory.getPersistenceManager().login(email, password);
    }

    public void createHousehold(Household authenticatedHousehold) {
        createdHouseholdLiveData = persistenceManagerFactory.getPersistenceManager().createHouseholdInFirestoreIfNotExists(authenticatedHousehold);
    }

}