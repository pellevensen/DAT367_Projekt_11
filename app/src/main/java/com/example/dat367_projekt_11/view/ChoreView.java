package com.example.dat367_projekt_11.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dat367_projekt_11.databinding.FragmentChoreBinding;
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.viewModels.ChoreViewModel;
import com.example.dat367_projekt_11.R;

public class ChoreView extends Fragment {

    private ChoreViewModel mViewModel;
    private TextView descriptionTitel;
    private TextView nametitle;
    private TextView chorePoints;
    private CheckBox completeChorecheckBox;
    private EditText description;
    private FragmentChoreBinding binding;

    public static ChoreView newInstance() {
        return new ChoreView();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    //    View view = inflater.inflate(R.layout.fragment_chore, container, false);
        binding = FragmentChoreBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
    description.findViewById(R.id.descriptionTextbox);
    nametitle.findViewById(R.id.choreTitle);
    chorePoints.findViewById(R.id.chorepointstitle);
    completeChorecheckBox.findViewById(R.id.signInBtn);
    descriptionTitel.findViewById(R.id.descriptionTitle);




    return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ChoreViewModel.class);
        // TODO: Use the ViewModel
    }

}