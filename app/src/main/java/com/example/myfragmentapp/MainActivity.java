package com.example.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        //buat fragmentnya (Object HomeFragment)
        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = manager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)){
            // tambahkan fragment Home ke fragment mamager melalui object transaction
            transaction.add(R.id.container,homeFragment,HomeFragment.class.getSimpleName());
            transaction.commit();
        }
    }
}
