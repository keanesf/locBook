package com.keanesf.locbook.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;
import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.adapaters.PlaceAdapter;
import com.keanesf.locbook.data.database.FavoriteEntry;
import com.keanesf.locbook.data.database.FavoriteListViewModel;
import com.keanesf.locbook.data.database.LocbookDatabase;
import com.keanesf.locbook.models.details.GooglePlaceDetailResponse;
import com.keanesf.locbook.models.search.GooglePlaceResponse;
import com.keanesf.locbook.models.search.Place;
import com.keanesf.locbook.services.PlaceService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;
import retrofit2.Call;

import static android.content.Context.LOCATION_SERVICE;


public class MasterListFragment extends Fragment implements PlaceAdapter.ItemClickListener {

    private List<Place> places;
    private PlaceAdapter placeAdapter;
    private PlaceClickListener placeClickListener;

    public static final String NEARBY_ACTION = "nearby.action";
    public static final String FAVORITE_ACTION = "favorite.action";
    public static String currentAction = NEARBY_ACTION;
    private LocbookDatabase locbookDatabase;
    private final String LOG_TAG = this.getClass().getSimpleName();
    private FavoriteListViewModel viewModel;

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

        setHasOptionsMenu(true);
        locbookDatabase = LocbookDatabase.getInstance(getContext());
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        ButterKnife.bind(this, rootView);
        placeAdapter = new PlaceAdapter(this);

        placeList.setNestedScrollingEnabled(false);

        placeList.setLayoutManager(new LinearLayoutManager(
                rootView.getContext(), LinearLayoutManager.VERTICAL, false));

        placeList.setHasFixedSize(true);
        placeList.setAdapter(placeAdapter);

        loadPlaces();

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
                        if(location != null){
                            double longitude = location.getLongitude();
                            double latitude = location.getLatitude();
                            myLocation = Double.toString(latitude) + "," + Double.toString(longitude);
                        }
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_main_activity, menu);
        MenuItem action_nearby = menu.findItem(R.id.action_nearby);
        MenuItem action_favorite = menu.findItem(R.id.action_favorites);

        if (currentAction.contentEquals(NEARBY_ACTION)) {
            if (!action_nearby.isChecked()) {
                action_nearby.setChecked(true);
            }
        } else if (currentAction.contentEquals(FAVORITE_ACTION)) {
            if (!action_favorite.isChecked()) {
                action_favorite.setChecked(true);
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_nearby:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                currentAction = NEARBY_ACTION;
                loadPlaces();
                return true;
            case R.id.action_favorites:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                currentAction = FAVORITE_ACTION;
                loadPlaces();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadPlaces(){
        if (FAVORITE_ACTION.equals(currentAction)){
            LiveData<List<FavoriteEntry>> favoriteEntries = locbookDatabase.favoriteDao().getAll();

            viewModel = ViewModelProviders.of(this).get(FavoriteListViewModel.class);

            viewModel.getFavoriteEntries().observe(this, new Observer<List<FavoriteEntry>>(){
                public void onChanged(@Nullable List<FavoriteEntry> favoriteEntries) {
                    Log.d(LOG_TAG, "Receiving database update from LiveData");
                    // convert favorites to places
                    List<Place> places = new ArrayList<>();
                    for(FavoriteEntry favoriteEntry: favoriteEntries){
                        Place place = new Place();
                        place.setPlaceId(favoriteEntry.getId());
                        place.setName(favoriteEntry.getName());
                        place.setRating(favoriteEntry.getRating());
                        place.setTypes(favoriteEntry.getTypes());
                        place.setPhotos(favoriteEntry.getPhotos());
                        places.add(place);
                    }
                    placeAdapter.setPlaces(places);
                }
            } );
        }
        else
            new FetchPlacesTask().execute();
    }
}