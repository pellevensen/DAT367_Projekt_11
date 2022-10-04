package com.example.dat367_projekt_11.view;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.models.Profile;

public class ScoreboardActivity extends AppCompatActivity {

    TextView Scores;

    int best1 = 8;
    int best2 = 4;
    int best3 = 2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scoreboard);

        Scores = (TextView) findViewById(R.id.Scores);

        Scores.setText("#1" + best1 + "\n" +
                "#2" + best2 + "\n" +
                "#3" + best3 + "\n");

    }


    /*TextView Scores;


    int best1, best2, best3;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){

        Scores.setText("#1" + best1 + "\n" +
                            "#2" + best2 + "\n" +
                            "#3" + best3 + "\n");

    }*/

}
