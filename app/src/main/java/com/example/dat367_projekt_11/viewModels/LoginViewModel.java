package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Household;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<String> householdName = new MutableLiveData<>();
    private MutableLiveData<List> profileList = new MutableLiveData<>();
    private MutableLiveData<Household> householdMutableLiveData;
    private MutableLiveData<String> toastMessage = new MutableLiveData<>();



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

    public MutableLiveData<Household> getHousehold() {

        if (householdMutableLiveData == null) {
            householdMutableLiveData = new MutableLiveData<>();
        }
        return householdMutableLiveData;

    }

    public MutableLiveData<String> getToastMessage(){

        if (toastMessage == null) {
            toastMessage = new MutableLiveData<>();
        }
        return toastMessage;
    }
    public void onLoginClicked() {
        Household household = new Household(email.getValue(), password.getValue(), householdName.getValue());
        householdMutableLiveData.setValue(household);
        household.setEmail(email.getValue());
        household.setPassword(password.getValue());
        household.setHouseholdName(householdName.getValue());
        if(checkIfPasswordEmailTypedIn(household.getEmail(), household.getPassword())) {
            household.getmAuth().signInWithEmailAndPassword(household.getEmail(), household.getPassword()).addOnCompleteListener(
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