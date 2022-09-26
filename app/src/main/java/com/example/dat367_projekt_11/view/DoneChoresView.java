package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dat367_projekt_11.databinding.FragmentDonechoresmodelBinding;

import com.example.dat367_projekt_11.viewModels.DoneChoresViewModel;

public class DoneChoresView extends Fragment {

private FragmentDonechoresmodelBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        DoneChoresViewModel doneChoresViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(DoneChoresViewModel.class);

    binding = FragmentDonechoresmodelBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        doneChoresViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}