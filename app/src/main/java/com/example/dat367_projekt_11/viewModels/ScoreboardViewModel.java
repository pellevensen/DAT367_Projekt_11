package com.example.dat367_projekt_11.viewModels;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.view.ScoreboardFragment;

public class ScoreboardViewModel extends AndroidViewModel {
    public ScoreboardViewModel(@NonNull Application application) {
        super(application);
    }
        // TODO: Implement the ViewModel

    /*private static final Profile currentPoints = new Profile();
    private static int memberScore = currentPoints.getCurrentPoints();*/


    private SharedPreferences getSharedPreferences (String pref,int i){
        return null;
    }

    private ScoreboardFragment mFragment;


    @SuppressLint("SetTextI18n")
    public void rankProfiles () {
        System.out.println("Snälla säg att den kommer hit");

        mFragment = new FragmentProvider(this ).get(ScoreboardFragment.class);


        SharedPreferences preferences = getSharedPreferences("PREF", +0);
        int memberScore = preferences.getInt("memberScore", 10/*memberScore*/);
        /*int bestOne = preferences.getInt("points1", 8);
        int bestTwo = preferences.getInt("points2", 4);*/
        int bestThree = preferences.getInt("points3", 2);

        if (memberScore > bestThree) {
            bestThree = memberScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", bestThree);
            editor.apply();
        }

        /*if (memberScore > bestTwo) {
            int temp = bestTwo;
            bestTwo = memberScore;
            bestThree = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", bestThree);
            editor.putInt("points2", bestTwo);
            editor.apply();
        }

        if (memberScore > bestOne) {
            int temp = bestOne;
            bestOne = memberScore;
            bestTwo = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points2", bestTwo);
            editor.putInt("points1", bestOne);
            editor.apply();
        }*/




    }


}

