package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.dat367_projekt_11.R;

public class StartFragment extends Fragment implements View.OnClickListener {
    private Button gotoLogin;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        gotoLogin = view.findViewById(R.id.signInBtn);
        gotoLogin.setOnClickListener(this);


        return view;
    }
    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_startFragment_to_loginFragment);
    }
}