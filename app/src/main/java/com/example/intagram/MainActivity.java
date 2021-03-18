package com.example.intagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_con,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_hom:
                            selectedFragment = new HomeFragment();
                            break;
                    }
                    switch (item.getItemId()){
                        case R.id.nav_mess:
                            selectedFragment = new MessageFragment();
                            break;
                    }
                    switch (item.getItemId()){
                        case R.id.nav_per:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    switch (item.getItemId()){
                        case R.id.nav_sear:
                            selectedFragment = new SeachFragment()
                            ;
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_con, selectedFragment).commit();
                    return true;
                }
            };

}