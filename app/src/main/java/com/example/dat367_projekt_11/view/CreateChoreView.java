package com.example.dat367_projekt_11.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dat367_projekt_11.databinding.FragmentCreateChorePageBinding;
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.viewModels.CreateChoreViewModel;
import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

import java.util.Objects;

public class CreateChoreView extends Fragment {

    private CreateChoreViewModel createChoreViewModel;
    private Button doneButton;
    private FragmentCreateChorePageBinding binding;
    private RadioGroup radioGroup;

    public static CreateChoreView newInstance() {
        return new CreateChoreView();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createChoreViewModel = new ViewModelProvider(this).get(CreateChoreViewModel.class);
        // TODO: Use the ViewModel
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateChorePageBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        createChoreViewModel = new ViewModelProvider(this).get(CreateChoreViewModel.class);
        binding.setCreateChoreViewModel(createChoreViewModel);
        createChoreViewModel.getChore().observe(getViewLifecycleOwner(), new Observer<Chore>() {


            public void onChanged(@Nullable Chore chore) {
                if (TextUtils.isEmpty(Objects.requireNonNull(chore).getName())) {
                    Toast.makeText(getActivity(),"Enter the chore name",Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.nameText.setText(chore.getName());
                }
                if (TextUtils.isEmpty(Objects.requireNonNull(chore).getDescription())) {
                    Toast.makeText(getActivity(),"Enter the chore description",Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.descriptionText.setText(chore.getDescription());

                }
                switch(radioGroup.getCheckedRadioButtonId()){
                    case(R.id.radioButton): /*Sätt poängen till 10*/break;
                    case(R.id.radioButton2): /*Sätt poägen till 20*/break;
                    case(R.id.radioButton3): /*Sätt poängen till 30*/break;

                }
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}