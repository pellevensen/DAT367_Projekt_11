package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<String> s;

    public ProfileViewModel() {
        s = new MutableLiveData<>();
        s.setValue("hej"
        );
    }
    public LiveData<String> getText() {
        return s;
    }
}