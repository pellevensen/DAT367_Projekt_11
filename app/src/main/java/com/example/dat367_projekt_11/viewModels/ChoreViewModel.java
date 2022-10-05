package com.example.dat367_projekt_11.viewModels;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.ChoreListStatusListener;
import com.example.dat367_projekt_11.models.Household;

import java.util.ArrayList;

public class ChoreViewModel extends ViewModel implements ChoreListStatusListener {
    private Chore chore;
    private Household household;
    private MutableLiveData<Chore> userMutableLiveData;

    public MutableLiveData<Chore> getHousehold() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }
   // household.subscribe(this);


    // TODO: Implement the ViewModel
    //skapa metoder för att koppla info till textfields etc -> namn/beskrivning/boolean
    //



    public void onCheckBoxclicked(){
        chore.completeChore();
    }

    //tar in arraylist med information för varje chore
    @Override
    public void update(ArrayList<Chore> choreList) {
        for(Chore chore: choreList){
//            CardView card = new CardView(chore.getDescription(),chore.getName(), chore.getPoints(),chore.isComplete());
            chore.getDescription();
            chore.getName();
            chore.getPoints();
            chore.isComplete();
        }

    }
}