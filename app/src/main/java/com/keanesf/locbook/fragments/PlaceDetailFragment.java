package com.keanesf.locbook.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keanesf.locbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceDetailFragment extends Fragment {

    private String placeId;

    @BindView(R.id.place_title)
    TextView placeTitle;

    public PlaceDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        ButterKnife.bind(this, rootView);

        placeTitle.setText(placeId);

        return rootView;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
