package com.keanesf.locbook.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.keanesf.locbook.R;
import com.keanesf.locbook.fragments.PlaceDetailFragment;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        FragmentManager fragmentManager = getSupportFragmentManager();

        PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.place_container, placeDetailFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.place_container, placeDetailFragment)
                    .commit();
        }


    }
}
