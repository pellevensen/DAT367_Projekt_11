package com.example.dat367_projekt_11.viewModels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.dat367_projekt_11.BR;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.User;

import java.util.ArrayList;

public class ProfileViewModel extends BaseObservable {
    private final User user;
    private final Profile profile;

    public ProfileViewModel() {
        user = new User("","", "",new ArrayList<>(),new ArrayList<>());
        profile = new Profile("",new ArrayList<>(), new ArrayList<>());
    }
    @Bindable
    public String getProfileName() {
        return profile.getName();
    }

    public void setProfileName(String name) {
        profile.setName(name);
        notifyPropertyChanged(BR.profileName);
    }
   /* public void onNewProfileClicked(){
        user.addProfile(getProfileName(), profile);*/
    }

   /* public void onProfileClicked(){
        user.setCurrentProfile(profile);*/



