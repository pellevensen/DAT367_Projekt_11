package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Household;

import java.util.HashMap;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<HashMap> profileList = new MutableLiveData<>();

    private MutableLiveData<Household> userMutableLiveData;

    public MutableLiveData<Household> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }
    public void onLoginClicked() {
        Household loginHousehold = new Household(email.getValue(), password.getValue(), "");
        userMutableLiveData.setValue(loginHousehold);
        loginHousehold.setEmail(email.getValue());
        loginHousehold.setPassword(password.getValue());
        if(checkIfPasswordEmailTypedIn(loginHousehold.getEmail(), loginHousehold.getPassword())) {
            loginHousehold.getmAuth().signInWithEmailAndPassword(loginHousehold.getEmail(), loginHousehold.getPassword());
        }
    }

    private Boolean checkIfPasswordEmailTypedIn(String email, String password) {
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            return false;
        }
        else{
            return true;
        }
    }

}