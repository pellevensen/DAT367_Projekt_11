package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.databinding.FragmentChoreBinding;
import com.example.dat367_projekt_11.databinding.FragmentDonechoresmodelBinding;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.viewModels.ChoreViewModel;
import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoneChoresView extends Fragment {
    private FragmentDonechoresmodelBinding binding;
    private ChoreViewModel choreViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDonechoresmodelBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        populateData();
        return binding.getRoot();
    }

    private void populateData() {
        List<Chore> choreModelList = new ArrayList<>();


        ChoreAdapter choreAdapter = new ChoreAdapter(choreModelList, getContext());

        binding.setChoreAdapter(choreAdapter);
    }


/*
    private ChoreViewModel choreViewModel;
    private TextView descriptionTitel;
    private TextView nametitle;
    private TextView chorePoints;
    private CheckBox completeChorecheckBox;
    private EditText description;
    private FragmentChoreBinding binding;

    public static ChoreView newInstance() {
        return new ChoreView();
    }*/


}
