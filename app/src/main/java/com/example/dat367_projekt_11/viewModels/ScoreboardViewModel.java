package com.example.dat367_projekt_11.viewModels;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.view.ScoreboardFragment;

public class ScoreboardViewModel extends AndroidViewModel {
    public ScoreboardViewModel(@NonNull Application application) {
        super(application);
    }
    // TODO: Implement the ViewModel

    /*public MutableLiveData<String> RankingOfScoresText = new MutableLiveData<>();*/

    private MutableLiveData<ScoreboardViewModel> scoreboardFragmentMutableLiveData;

    public MutableLiveData<ScoreboardViewModel> getScoreboardFragment() {

        if (scoreboardFragmentMutableLiveData == null) {
            scoreboardFragmentMutableLiveData = new MutableLiveData<>();
        }
        return scoreboardFragmentMutableLiveData;


    }

    private MutableLiveData<ScoreboardViewModel> scoreboardModelMutableLiveData;

    public MutableLiveData<ScoreboardViewModel> getScoreboardModel() {

        if (scoreboardModelMutableLiveData == null) {
            scoreboardModelMutableLiveData = new MutableLiveData<>();
        }
        return scoreboardModelMutableLiveData;

    }


    public MutableLiveData<String> rankingText = new MutableLiveData<>();

    private MutableLiveData<Household> userMutableLiveData;

    public MutableLiveData<Household> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    private static final ScoreboardModel rankingOfScoresText = new ScoreboardModel();
    private static final String rankingOfScores = rankingOfScoresText.getRankingOfScoresText();

    public void onLeaderboardClicked(){

        rankingText.setValue("Hej");

        System.out.println(rankingText.getValue());
        System.out.println("bajsa på dig");

    }


}


