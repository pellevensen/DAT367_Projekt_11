package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentDonechoresBinding;
import com.example.dat367_projekt_11.databinding.FragmentMainpageBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;
import com.example.dat367_projekt_11.viewModels.MainPageViewModel;

import java.util.List;

public class MainPageView extends Fragment {
private Button createButton;
private FragmentMainpageBinding binding;
private MainPageViewModel mainPageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainpageBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        mainPageViewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
        binding.setMainPageViewModel(mainPageViewModel);
        populateData();
        return binding.getRoot();



    }

    private void populateData() {
        List<Chore> choreModelList = mainPageViewModel.getChoreModellist();

        ChoreAdapter choreAdapter = new ChoreAdapter(choreModelList, getContext());
        binding.setChoreAdapter(choreAdapter);
    }
/*
@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/


}