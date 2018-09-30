package com.keanesf.locbook.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.models.details.GooglePlaceDetailResponse;
import com.keanesf.locbook.models.details.Place;
import com.keanesf.locbook.services.PlaceService;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class PlaceDetailFragment extends Fragment {

    private String placeId;

    String PLACE_IMAGE_URI = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=600&photoreference={{Photo_Reference}}&key={{API_KEY}}";


    @BindView(R.id.place_title)
    TextView placeTitle;

    @BindView(R.id.place_image)
    ImageView placeImage;

    public PlaceDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        ButterKnife.bind(this, rootView);

        //placeTitle.setText(placeId);

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
                placeTitle.setText(place.getName());

                String myPlaceImageUri = null;
                if(place.getPhotos() != null && place.getPhotos().size() > 0){
                    myPlaceImageUri = PLACE_IMAGE_URI;
                    myPlaceImageUri = myPlaceImageUri
                            .replace("{{Photo_Reference}}", place.getPhotos().get(0).getPhotoReference())
                            .replace("{{API_KEY}}", BuildConfig.API_KEY);

                }

                if (myPlaceImageUri != null) {
                    Picasso.with(getContext())
                            .load(myPlaceImageUri)
                            //.placeholder(R.drawable.image_placeholder)
                            //.error(R.drawable.image_placeholder)
                            .into(placeImage);
                }


            }
        }
    }
}
