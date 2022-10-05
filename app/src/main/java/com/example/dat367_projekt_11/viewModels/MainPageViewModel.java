package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Household;

public class MainPageViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    //private ChoreList chorelist;
    public MainPageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(""/*chorelist */);
    }

    public LiveData<String> getText() {
        return mText;
    }




    }
