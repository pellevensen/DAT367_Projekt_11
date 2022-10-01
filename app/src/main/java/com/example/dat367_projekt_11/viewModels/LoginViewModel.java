package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.User;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }


    public void onLoginClicked() {
        User loginUser = new User(email.getValue(), password.getValue(), "");
        userMutableLiveData.setValue(loginUser);
        loginUser.setEmail(email.getValue());
        loginUser.setPassword(password.getValue());
        if(checkIfPasswordEmailTypedIn(loginUser.getEmail(), loginUser.getPassword())) {
            loginUser.getmAuth().signInWithEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
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