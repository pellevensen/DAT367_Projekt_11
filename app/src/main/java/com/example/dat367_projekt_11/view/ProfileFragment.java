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
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentProfileBinding;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment{
    private FragmentProfileBinding binding;
    private LoginViewModel loginViewModel;
    private Button addProfile;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        addProfile = binding.getRoot().findViewById(R.id.addProfile);
        addProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_profileFragment_to_addProfileFragment);
            }
        });
        populateData();
        return binding.getRoot();
    }

    private void populateData() {
        List<Profile> profileModelList = new ArrayList<>();

        profileModelList.add(new Profile("Mamma"));
        profileModelList.add(new Profile("Pappa"));
        profileModelList.add(new Profile("storasyster"));
        profileModelList.add(new Profile("lillebror"));

        ProfileAdapter profileAdapter = new ProfileAdapter(profileModelList, getContext());
        binding.setProfileAdapter(profileAdapter);
    }

}