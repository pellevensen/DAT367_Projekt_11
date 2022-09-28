package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dat367_projekt_11.viewModels.ChoreViewModel;
import com.example.dat367_projekt_11.R;

public class ChoreView extends Fragment {

    private ChoreViewModel mViewModel;

    public static ChoreView newInstance() {
        return new ChoreView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chore, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ChoreViewModel.class);
        // TODO: Use the ViewModel
    }

}