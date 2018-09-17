package com.keanesf.locbook.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keanesf.locbook.R;
import com.keanesf.locbook.fragments.MasterListFragment;

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
}
