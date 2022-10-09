package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentRegistrationBinding;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setViewModel(loginViewModel);
        setRegistrationBtnOnAction(binding.getRoot());
        return binding.getRoot();
    }

    private void setRegistrationBtnOnAction(View view) {
        Button loginButton = view.findViewById(R.id.registerBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginViewModel.getEmail().getValue();
                String password = loginViewModel.getPassword().getValue();
                String householdName = loginViewModel.getHouseholdName().getValue();
                if (email.length() > 0 && password.length() > 0) {
                    register(email, password, householdName);
                } else {
                    Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register(String email, String password, String householdName) {
        loginViewModel.register(email, password, householdName);
        goToLoginFragment();
    }

    private void goToLoginFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_loginFragment);
    }
}