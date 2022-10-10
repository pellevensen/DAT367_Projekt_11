package com.example.dat367_projekt_11.viewModels;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.models.User;
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

    public MutableLiveData<String> makeScores = new MutableLiveData<>();

    private MutableLiveData<ScoreboardFragment> scoreboardFragmentMutableLiveData;

    public MutableLiveData<ScoreboardFragment> getScoreboardFragment() {

        if (scoreboardFragmentMutableLiveData == null) {
            scoreboardFragmentMutableLiveData = new MutableLiveData<>();
        }
        return scoreboardFragmentMutableLiveData;
    }

    public void rankProfiles () {
        System.out.println("Snälla säg att den kommer hit");


        /*getSharedPreferences("PREF", +0);*/

        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        int memberScore = preferences != null ? preferences.getInt("memberScore", 0/*memberScore*/) : 0;
        /*int bestOne = preferences.getInt("points1", 0);
        int bestTwo = preferences.getInt("points2", 0);*/
        int bestThree = preferences != null ? preferences.getInt("points3", 0) : 0;


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


        makeScores.setValue(/*"1" + best1 + "\n" +
                "#2" + best2 + "\n" +*/
                "#3" + bestThree);

    }
}


