package com.keanesf.locbook.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keanesf.locbook.R;
import com.keanesf.locbook.fragments.MasterListFragment;
import com.keanesf.locbook.models.Place;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.master_list_container, new MasterListFragment())
                    .commit();
        }
    }

//    @Override
//    public void onPlaceClicked(Place place) {
//        Intent intent = new Intent(this, PlaceDetailActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("place", place);
//        intent.putExtras(bundle);
//        startActivity(intent);
//    }
}
