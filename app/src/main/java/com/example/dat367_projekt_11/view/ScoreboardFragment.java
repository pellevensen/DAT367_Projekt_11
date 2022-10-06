package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

public class ScoreboardFragment extends Fragment {

    private ScoreboardViewModel mViewModel;

    private ScoreboardModel scoreboardModel;

    public static ScoreboardFragment newInstance() {
        return new ScoreboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_scoreboard, container, false);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }




    Profile currentPoints=new Profile();
    private int memberScore = currentPoints.getCurrentPoints();



    @SuppressLint("SetTextI18n")

    public static void makeScores(){

        TextView scores = (TextView) findViewById(R.id.Scores);

        SharedPreferences preferences = getSharedPreferences("PREF", +0);
        memberScore = preferences.getInt("memberScore", memberScore);
        int best1 = preferences.getInt("points1", 0);
        int best2 = preferences.getInt("points2", 0);
        int best3 = preferences.getInt("points3", 0);

        if( memberScore > best3){
            best3 = memberScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.apply();
        }

        if( memberScore > best2){
            int temp = best2;
            best2 = memberScore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.putInt("points2", best2);
            editor.apply();
        }

        if( memberScore > best1){
            int temp = best1;
            best1 = memberScore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points2", best2);
            editor.putInt("points1", best1);
            editor.apply();
        }


        scores.setText("#1" + best1 + "\n" +
                "#2" + best2 + "\n" +
                "#3" + best3);



    }


    /*@Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }*/

}