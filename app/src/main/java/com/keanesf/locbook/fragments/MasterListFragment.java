package com.keanesf.locbook.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;
import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.adapaters.PlaceAdapter;
import com.keanesf.locbook.models.GooglePlaceResponse;
import com.keanesf.locbook.models.Place;
import com.keanesf.locbook.services.PlaceService;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;
import retrofit2.Call;


public class MasterListFragment extends Fragment implements PlaceAdapter.ItemClickListener {

    private List<Place> places;
    private PlaceAdapter placeAdapter;
    private PlaceClickListener placeClickListener;

    @BindView(R.id.place_list)
    RecyclerView placeList;

    @BindView(R.id.spin_kit)
    SpinKitView spinKitView;

    public MasterListFragment(){}

    @Override
    public void onClick(Place place) {
        placeClickListener.onPlaceClicked(place);
    }

    public interface PlaceClickListener {
        void onPlaceClicked(Place place);
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        ButterKnife.bind(this, rootView);
        placeAdapter = new PlaceAdapter(this);

        placeList.setNestedScrollingEnabled(false);

        placeList.setLayoutManager(new LinearLayoutManager(
                rootView.getContext(), LinearLayoutManager.VERTICAL, false));

        placeList.setHasFixedSize(true);
        placeList.setAdapter(placeAdapter);

        new FetchPlacesTask().execute();

        return rootView;
    }



    public class FetchPlacesTask extends AsyncTask<String, Void, List<Place> >{

        private final String LOG_TAG = FetchPlacesTask.class.getSimpleName();

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected List<Place>  doInBackground(String... params) {

//            if (params.length == 0) {
//                Log.e(LOG_TAG, "No params provided!");
//                return null;
//            }


            PlaceService placeService = PlaceService.retrofit.create(PlaceService.class);

            try {
                    // todo get current location of user
                    String location = "-33.8670522,151.1957362";

                    String radius = "1500";

                    Call<GooglePlaceResponse<Place>> apiCall =
                            placeService.listPlaces(location, radius, BuildConfig.API_KEY);
                    return apiCall.execute().body().getResults();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Place> places) {
            if (places != null) {
                if ( placeAdapter != null) {
                    placeAdapter.setPlaces(places);
                }
            }
        }
    }
}