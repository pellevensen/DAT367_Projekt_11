package com.example.dat367_projekt_11.models;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;


public class ScoreboardModel extends AppCompatActivity {

   /* Behöver en instans av user för att få tillgång till alla profiler - Hanna och Malin
   * motsvarande repaint för att uppdatera textview
   * scores.postInvalidate();
   * kolla om oncreate blir called
   * använd System.out.println("Pauline");*/

    Profile currentPoints=new Profile();
    private int memberScore = currentPoints.getCurrentPoints();



    @SuppressLint("SetTextI18n")

    public void makeScores(){
        System.out.println("hej");
        setContentView(R.layout.fragment_scoreboard);

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
