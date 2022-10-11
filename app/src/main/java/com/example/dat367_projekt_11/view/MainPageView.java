package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentMainpageBinding;

public class MainPageView extends Fragment {
    private Button createButton;
    private FragmentMainpageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_chore_page, container, false);

        createButton = view.findViewById(R.id.signInBtn);
      /*  createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.nav_host_fragment_activity_main); //TODO ändra detta så det blir rätt frgment
            }
        });*/
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}