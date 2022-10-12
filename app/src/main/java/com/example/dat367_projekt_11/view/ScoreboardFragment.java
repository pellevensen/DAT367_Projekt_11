package com.example.dat367_projekt_11.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentScoreboardBinding;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.ScoreboardModel;
import com.example.dat367_projekt_11.viewModels.ScoreboardViewModel;

import org.w3c.dom.Text;



import java.text.BreakIterator;
import java.util.Objects;

public class ScoreboardFragment extends Fragment{


    private ScoreboardViewModel fViewModel;

    /*String ranking = "hej";*/

    private FragmentScoreboardBinding binding;

    public MutableLiveData<String> rankingText = new MutableLiveData<>();



    public static ScoreboardFragment newInstance() {
        return new ScoreboardFragment();
    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {;

        binding = FragmentScoreboardBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        fViewModel = new ViewModelProvider(this ).get(ScoreboardViewModel.class);
        /*binding.setScoreboardViewModel(fViewModel);*/
        rankingText.setValue("Hej hallå");
        
        /*onLeaderboardClicked(rankingOfScoresText);*/

        return binding.getRoot(); /*inflater.inflate(R.layout.fragment_scoreboard, container, false);*/
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

/*private final ScoreboardModel rankProfiles = new ScoreboardModel();
    private numberOne = bestOne.getBestOne;*/

    /*private TextView scores;*/


   /* public void onLeaderboardClicked(String s){

        rankingText.setText(s);

    }*/

}