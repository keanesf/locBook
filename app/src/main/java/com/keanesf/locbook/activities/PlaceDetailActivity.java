package com.keanesf.locbook.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.keanesf.locbook.R;
import com.keanesf.locbook.fragments.PlaceDetailFragment;
import com.keanesf.locbook.widget.PlaceService;

import butterknife.BindView;

public class PlaceDetailActivity extends AppCompatActivity {

    @BindView(R.id.parent_container)
    FrameLayout parentContainer;

    public static String placeTitle = "Place Title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String placeId = bundle.getString("placeId");

        FragmentManager fragmentManager = getSupportFragmentManager();

        PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();

        placeDetailFragment.setPlaceId(placeId);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_place_detail_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        boolean placeAdded;
        if (itemId == R.id.action_add) {
            placeAdded = PlaceService.startActionChangePlace(this);

            if (placeAdded)
                Snackbar.make(parentContainer, R.string.widget_added_text, Snackbar.LENGTH_SHORT).show();
            else
                Snackbar.make(parentContainer, R.string.widget_not_added_text, Snackbar.LENGTH_SHORT).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
