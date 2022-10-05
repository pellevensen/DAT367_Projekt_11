package com.example.dat367_projekt_11.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;

public class ScoreboardView extends AppCompatActivity{

    TextView Scores;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scoreboard);

        Scores = (TextView) findViewById(R.id.Scores);

        Scores.setText("Hej");

    }

}
