package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.DoneChoresListener;
import com.example.dat367_projekt_11.models.Profile;

import java.util.ArrayList;

public class DoneChoresViewModel extends ViewModel implements DoneChoresListener {
    private Profile profile;
    private final MutableLiveData<String> mText;

    public DoneChoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("@string/done_ChoreTitle");
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void update(ArrayList<Chore> choreList) {
        /*TODO implementera ett sätt att ta listan av donechores och presenterad dem som cards
                för varje donechore
         */

    }
}