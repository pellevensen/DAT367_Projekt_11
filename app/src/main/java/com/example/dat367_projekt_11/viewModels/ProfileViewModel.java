package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Profile;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> name;
    private MutableLiveData<Profile> profileMutableLiveData;

    public MutableLiveData<String> getName(){

        if (name == null) {
            name = new MutableLiveData<>();
        }
        return name;
    }

    public MutableLiveData<Profile> getProfile(){

        if (profileMutableLiveData == null) {
            profileMutableLiveData = new MutableLiveData<>();
        }
        return profileMutableLiveData;
    }

    public void onAddProfileClicked() {
        Profile profile = new Profile(name.getValue());
        profileMutableLiveData.setValue(profile);
        profile.setName(name.getValue());
        }


}