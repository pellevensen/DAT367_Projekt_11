package com.example.dat367_projekt_11.models;


import android.app.Application;

public class PersistenceManagerFactory {
    public PersistenceManager getPersistenceManager(Application application){
        return new PersistenceManager(application);
    }
}
