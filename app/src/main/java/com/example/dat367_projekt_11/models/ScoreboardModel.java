package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;


public class ScoreboardModel extends AppCompatActivity {


    /*private static final Profile currentPoints = new Profile();
    private static int memberScore = currentPoints.getCurrentPoints();*/


    public SharedPreferences getSharedPreferences (String pref,int i){
        return null;
    }

    private ScoreboardViewModel mViewModel;



    private MutableLiveData<ScoreboardViewModel> scoreboardViewModelMutableLiveData;

    public MutableLiveData<ScoreboardViewModel> getScoreboardViewModel() {

        if (scoreboardViewModelMutableLiveData == null) {
            scoreboardViewModelMutableLiveData = new MutableLiveData<>();
        }
        return scoreboardViewModelMutableLiveData;
    }

    @SuppressLint("SetTextI18n")
    public String rankProfiles () {

        mViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);


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


        String RankingOfScoresText= "Hejsan svejsan" /*"1" + best1 + "\n" +
                "#2" + best2 + "\n" +
                "#3" + bestThree*/;

        return RankingOfScoresText;



    }



}
