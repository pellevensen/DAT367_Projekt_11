package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.ChoreListStatusListener;

import java.util.ArrayList;

public class MainPageViewModel extends ViewModel implements ChoreListStatusListener {

    private final MutableLiveData<String> mText;

    public MainPageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    @Override
    public void update(ArrayList<Chore> choreList) {
        /*TODO koppla sidan till alla available chores

         */
    }
}