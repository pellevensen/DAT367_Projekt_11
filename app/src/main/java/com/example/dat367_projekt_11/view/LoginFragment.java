package com.example.dat367_projekt_11.view;

import androidx.fragment.app.Fragment;

import com.example.dat367_projekt_11.viewModels.LoginViewModel;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

   /* private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                        *//*     ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel loginViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView email = binding.email;
        final TextView password = binding.password;
        *//**//*loginViewModel.getTextEmail().observe(getViewLifecycleOwner(), email::setText);
        loginViewModel.getTextPassword().observe(getViewLifecycleOwner(), password::setText);*//**//*
        return root;*//*
    }*/

}