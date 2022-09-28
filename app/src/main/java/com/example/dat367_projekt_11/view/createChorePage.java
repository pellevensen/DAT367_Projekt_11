package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dat367_projekt_11.viewModels.CreateChorePageViewModel;
import com.example.dat367_projekt_11.R;

public class createChorePage extends Fragment {

    private CreateChorePageViewModel mViewModel;

    public static createChorePage newInstance() {
        return new createChorePage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_chore_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateChorePageViewModel.class);
        // TODO: Use the ViewModel
    }


}