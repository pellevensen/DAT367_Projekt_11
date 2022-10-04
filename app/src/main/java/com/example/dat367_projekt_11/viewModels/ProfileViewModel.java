package com.example.dat367_projekt_11.viewModels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.dat367_projekt_11.BR;
import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.Household;

public class ProfileViewModel extends BaseObservable {
    private final Household household;
    private final Profile profile;

    public ProfileViewModel() {
        household = new Household("","", "");
        profile = new Profile("");
    }
    @Bindable
    public String getProfileName() {
        return profile.getName();
    }

    public void setProfileName(String name) {
        profile.setName(name);
        notifyPropertyChanged(BR.profileName);
    }
    public void onNewProfileClicked(){
        household.addProfile(profile);
    }

    public void onProfileClicked(){
        household.setCurrentProfile(profile);
    }


}