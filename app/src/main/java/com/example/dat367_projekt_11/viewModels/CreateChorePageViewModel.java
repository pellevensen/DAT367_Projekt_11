package com.example.dat367_projekt_11.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.dat367_projekt_11.models.Household;

import java.util.Objects;

public class CreateChorePageViewModel extends ViewModel {


  private Household household;
  private String name;
  private String description;
  private int points;

        private String getName () {
                return Objects.requireNonNull(this.name);
        }
        public void setName (String name){
        this.name = Objects.requireNonNull(name);
    }

        private String getDescription () {
        return Objects.requireNonNull(this.name);
    }
        public void setDescription (String description){
        this.description = Objects.requireNonNull(description);
    }

        private int getPoints () {
            return Objects.requireNonNull(points);}
        public void setPoints(int points){
            this.points = Objects.requireNonNull(points);

        }

        private void addChore() {
            household.addNewChoreToList(getName(), getDescription(), getPoints());
        }


}
