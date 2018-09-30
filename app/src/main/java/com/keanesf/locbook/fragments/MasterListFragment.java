package com.keanesf.locbook.fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.keanesf.locbook.models.search.GooglePlaceResponse;
import com.keanesf.locbook.models.search.Place;
import com.keanesf.locbook.services.PlaceService;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;
import retrofit2.Call;

import static android.content.Context.LOCATION_SERVICE;


public class MasterListFragment extends Fragment implements PlaceAdapter.ItemClickListener {

    private List<Place> places;
    private PlaceAdapter placeAdapter;
    private PlaceClickListener placeClickListener;

    @BindView(R.id.place_list)
    RecyclerView placeList;

    @BindView(R.id.spin_kit)
    SpinKitView spinKitView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            placeClickListener = (PlaceClickListener) context;
        } catch (ClassCastException ec) {
            throw new ClassCastException(context.toString()
                    + " must implement RecipeListener");
        }
    }


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

            PlaceService placeService = PlaceService.retrofit.create(PlaceService.class);

            try {
                    String myLocation = "-33.8670522,151.1957362";

                    LocationManager locationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);

                    try {
                        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        double longitude = location.getLongitude();
                        double latitude = location.getLatitude();
                        myLocation = Double.toString(latitude) + "," + Double.toString(longitude);
                    }
                    catch(SecurityException e){
                        Log.e(LOG_TAG, "Error getting location", e);
                    }


                    String radius = "1500";

                    Call<GooglePlaceResponse<Place>> apiCall =
                            placeService.listPlaces(myLocation, radius, BuildConfig.API_KEY);
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