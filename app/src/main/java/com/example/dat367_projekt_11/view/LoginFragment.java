package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentLoginBinding;
import com.example.dat367_projekt_11.models.Household;
import com.example.dat367_projekt_11.viewModels.LoginViewModel;

import java.util.Objects;

public class LoginFragment extends Fragment{

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

   /* public static LoginFragment newInstance() {
        return new LoginFragment();
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getUserLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    //Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_profileFragment);
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        loginViewModel.getHousehold().observe(getViewLifecycleOwner(), new Observer<Household>() {
            @Override
            public void onChanged(@Nullable Household household) {

                if (TextUtils.isEmpty(Objects.requireNonNull(household).getEmail())) {
                    Toast.makeText(getActivity(),"Enter an E-Mail Address",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(household).getPassword())) {
                    Toast.makeText(getActivity(),"Enter a password",Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.emailTextView.setText(household.getEmail());
                    binding.passwordTextView.setText(household.getPassword());
                }

            }
        });
        loginViewModel.getToastMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {
                Toast.makeText(getActivity(),string,Toast.LENGTH_SHORT).show();
                if (Objects.equals(string, "Logged in Successfully!")){
                    Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_profileFragment);
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