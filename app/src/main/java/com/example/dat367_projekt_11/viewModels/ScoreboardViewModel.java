package com.example.dat367_projekt_11.viewModels;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.models.ScoreboardModel;

public class ScoreboardViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    getGetScore(){};

    public static void GetScores(String arg[]){
        System.out.println("Pauline vill bara att det här ska fungera nu");
        ScoreboardModel obj = new ScoreboardModel();
        obj.setScores();

    }




}