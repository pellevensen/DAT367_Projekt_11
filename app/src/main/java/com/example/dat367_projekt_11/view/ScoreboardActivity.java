package com.example.dat367_projekt_11.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;

public class ScoreboardActivity extends AppCompatActivity {

    TextView Scores;

    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scoreboard);

        Scores = (TextView) findViewById(R.id.Scores);

        SharedPreferences preferences = getSharedPreferences("PREF", +0);
        best1 = preferences.getInt("points1", 0);
        best2 = preferences.getInt("points2", 0);
        best3 = preferences.getInt("points3", 0);

        if( RandomNamesPoints > best3){
            ThirdPlace = RandomName;
            best3 = RandomNamesPoints;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.putString(RandomName, ThirdPlace);
            editor.apply();
        }

        if( RandomNamesPoints > best2){
            int temp = best2;
            SecondPlace = RandomName;
            best2 = RandomNamesPoints;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points3", best3);
            editor.putString(SecondPlaceRandomName, ThirdPlace);
            editor.putInt("points2", best2);
            editor.putString(RandomName, SecondPlace);
            editor.apply();
        }

        if( RandomNamesPoints > best1){
            int temp = best1;
            FirstPlace = RandomName;
            best1 = RandomNamesPoints;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("points2", best2);
            editor.putString(FirstPlaceRandomName, SecondPlace);
            editor.putInt("points1", best1);
            editor.putString(RandomName, FirstPlace);
            editor.apply();
        }

        Scores.setText("#1" + RandomName + best1 + "\n" +
                            "#2" + RandomName + best2 + "\n" +
                            "#3" + RandomName + best3 + "\n");

    }

}
