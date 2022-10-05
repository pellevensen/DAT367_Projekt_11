package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.databinding.FragmentMainpageBinding;
import com.example.dat367_projekt_11.viewModels.MainPageViewModel;

public class MainPageView extends Fragment {

private FragmentMainpageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        MainPageViewModel notificationsViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(MainPageViewModel.class);

    binding = FragmentMainpageBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.appTitle;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}