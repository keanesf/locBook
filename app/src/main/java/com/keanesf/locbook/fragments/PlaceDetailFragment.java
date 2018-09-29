package com.keanesf.locbook.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.models.details.GooglePlaceDetailResponse;
import com.keanesf.locbook.models.details.Place;
import com.keanesf.locbook.services.PlaceService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

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

        new FetchPlaceDetailsTask().execute();

        return rootView;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public class FetchPlaceDetailsTask extends AsyncTask<String, Void, Place > {

        private final String LOG_TAG = PlaceDetailFragment.FetchPlaceDetailsTask.class.getSimpleName();

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Place  doInBackground(String... params) {

            PlaceService placeService = PlaceService.retrofit.create(PlaceService.class);

            try {

                Call<GooglePlaceDetailResponse> apiCall =
                        placeService.getPlace(placeId, BuildConfig.API_KEY);

                return apiCall.execute().body().getResult();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Place place) {
            if (place != null) {
                //todo set data in view
                Log.i(LOG_TAG, place.getName());
            }
        }
    }
}
