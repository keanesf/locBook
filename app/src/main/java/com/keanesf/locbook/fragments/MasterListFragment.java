package com.keanesf.locbook.fragments;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.github.ybq.android.spinkit.SpinKitView;
import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.models.GooglePlaceResponse;
import com.keanesf.locbook.models.Place;
import com.keanesf.locbook.services.PlaceService;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

public class MasterListFragment extends Fragment {

    private List<Place> places;

    @BindView(R.id.recipe_list)
    RecyclerView placeList;
    @BindView(R.id.spin_kit)
    SpinKitView spinKitView;


    private static class FetchPlacesTask extends AsyncTask<String, String, String> {

        private final String LOG_TAG = FetchPlacesTask.class.getSimpleName();

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            if (params.length == 0) {
                Log.e(LOG_TAG, "No params provided!");
                return null;
            }


            PlaceService placeService = PlaceService.retrofit.create(PlaceService.class);

            try {
                    Call<GooglePlaceResponse<Place> apiCall = placeService.listPlaces(BuildConfig.API_KEY);
                    return apiCall.execute().body().getResults();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }
}