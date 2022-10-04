package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<String> householdName = new MutableLiveData<>();
    private MutableLiveData<List> profileList = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData;
    private MutableLiveData<String> toastMessage = new MutableLiveData<>();
    private MutableLiveData<Integer> navActionMutableLiveData = new MutableLiveData<>();



    public MutableLiveData<String> getEmail(){

        if (email == null) {
            email = new MutableLiveData<>();
        }
        return email;
    }

    public MutableLiveData<String> getPassword(){

        if (password == null) {
            password = new MutableLiveData<>();
        }
        return password;

    }

    public MutableLiveData<String> getHouseholdName(){

        if (householdName == null) {
            householdName = new MutableLiveData<>();
        }
        return householdName;
    }

    public MutableLiveData<List> getProfileList(){

        if (profileList == null) {
            profileList = new MutableLiveData<>();
        }
        return profileList;
    }

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public MutableLiveData<String> getToastMessage(){

        if (toastMessage == null) {
            toastMessage = new MutableLiveData<>();
        }
        return toastMessage;
    }

    public MutableLiveData<Integer> getNavActionMutableLiveData(){

        if (navActionMutableLiveData == null) {
            navActionMutableLiveData = new MutableLiveData<>();
        }
        return navActionMutableLiveData;
    }
    public void onLoginClicked() {
        User user = new User(email.getValue(), password.getValue(), householdName.getValue());
        userMutableLiveData.setValue(user);
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());
        user.setHouseholdName(householdName.getValue());
        if(checkIfPasswordEmailTypedIn(user.getEmail(), user.getPassword())) {
            user.getmAuth().signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(
                                @NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful()) {
                                toastMessage.setValue("Logged in Successfully!");
                            }

                            else {

                                toastMessage.setValue("Logged in not Successfully!");

                            }
                        }
                    });
        }
    }

    public void onNewProfileClicked(){
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