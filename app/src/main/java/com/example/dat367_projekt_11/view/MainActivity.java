package com.example.dat367_projekt_11.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {


    ScoreboardFragment scoreboardFragment = new ScoreboardFragment();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_donechores, R.id.navigation_leaderboard, R.id.navigation_profile)
                .build();*/

        bottomNavigationView = findViewById(R.id.nav_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,scoreboardFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                switch (item.getItemId()){
                    /*case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,);
                        return true;
                    case R.id.navigation_donechores:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,);
                        return true;*/
                    case R.id.navigation_leaderboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,scoreboardFragment);
                        return true;
                    /*case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,);
                        return true;*/
                }
                return false;
            }
        });
    }

}

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }*/

