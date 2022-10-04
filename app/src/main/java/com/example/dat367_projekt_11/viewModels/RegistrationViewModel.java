package com.example.dat367_projekt_11.viewModels;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.dat367_projekt_11.BR;
import com.example.dat367_projekt_11.models.Household;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationViewModel extends BaseObservable {
        private final Household household;
        private final FirebaseAuth mAuth;

        private final String successMessage = "Registration was successful";
        private final String errorMessage = "Email or Password not valid";

        public RegistrationViewModel() {
                household = new Household("","", "");
                this.mAuth = FirebaseAuth.getInstance();
        }
        @Bindable
        private String toastMessage = null;


        public String getToastMessage() {
                return toastMessage;
        }

        private void setToastMessage(String toastMessage) {
                this.toastMessage = toastMessage;
                notifyPropertyChanged(BR.toastMessage);
        }

        @Bindable
        public String getUserEmail() {
                return household.getEmail();
        }

        public void setUserEmail(String email) {
                household.setEmail(email);
                notifyPropertyChanged(BR.userEmail);
        }

        @Bindable
        public String getUserPassword() {
                return household.getPassword();
        }

        public void setUserPassword(String password) {
                household.setPassword(password);
                notifyPropertyChanged(BR.userPassword);
        }

        @Bindable
        public String getUserHouseholdName() {
                return household.getHouseholdName();
        }

        public void setHouseholdName(String householdName) {
                household.setHouseholdName(householdName);
                notifyPropertyChanged(BR.userHouseholdName);
        }

        public void onRegistrationClicked(){
                checkIfPasswordEmailTypedIn(getUserEmail(), getUserPassword());
                if(checkTypedInBool(getUserEmail(),getUserPassword())) {
                        mAuth.createUserWithEmailAndPassword(getUserEmail(), getUserPassword()).addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(
                                                @NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                        setToastMessage(successMessage);

                                                } else {

                                                        setToastMessage(errorMessage);

                                                }
                                        }
                                });
                }
        }
        private void checkIfPasswordEmailTypedIn(String email, String password){
                if (TextUtils.isEmpty(email)) {
                        setToastMessage("Please enter email!!");
                }

                if (TextUtils.isEmpty(password)) {
                        setToastMessage("Please enter password!!");
                }
        }
        private Boolean checkTypedInBool(String email, String password) {
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                        return false;
                }
                else{
                        return true;
                }
        }
}
