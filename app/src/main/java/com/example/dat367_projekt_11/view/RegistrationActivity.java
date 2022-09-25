package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ActivityRegistrationBinding;
import com.example.dat367_projekt_11.viewModels.RegistrationViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private Button btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityRegistrationBinding activityRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        activityRegistrationBinding.setViewModelRegistration(new RegistrationViewModel());
        activityRegistrationBinding.executePendingBindings();

    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
