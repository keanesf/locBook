package com.keanesf.locbook.adapaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


import com.keanesf.locbook.BuildConfig;
import com.keanesf.locbook.R;
import com.keanesf.locbook.models.search.Place;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ItemViewHolder> {

    String PLACE_IMAGE_URI = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=600&photoreference={{Photo_Reference}}&key={{API_KEY}}";

    private List<Place> places;
    private final ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onClick(Place place);
    }

    public PlaceAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.master_list_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        Place place = places.get(position);

        String placeName = places.get(position).getName();
        holder.placeTitle.setText(placeName);


        if(place.getTypes() != null && place.getTypes().size() > 0){
            // remove underscore and replace with a space
            holder.placeType.setText(place.getTypes().get(0).replace("_", " "));
        }
        else {
            holder.placeType.setText(R.string.default_place_type);
        }

        if(place.getRating() != null){
            holder.placeRating .setText(place.getRating().toString());
        }
        else
            holder.placeRating.setText(R.string.default_place_rating);


        String myPlaceImageUri = null;
        if(places.get(position).getPhotos() != null && places.get(position).getPhotos().size() > 0){
            myPlaceImageUri = PLACE_IMAGE_URI;
            myPlaceImageUri = myPlaceImageUri
                    .replace("{{Photo_Reference}}", place.getPhotos().get(0).getPhotoReference())
                    .replace("{{API_KEY}}", BuildConfig.API_KEY);

        }

        Context context = holder.itemView.getContext();

        if (myPlaceImageUri != null) {
            Picasso.with(context)
                    .load(myPlaceImageUri)
                    //.placeholder(R.drawable.image_placeholder)
                    //.error(R.drawable.image_placeholder)
                    .into(holder.placeThumbnail);
        }
    }


    @Override
    public int getItemCount() {
        if (places == null) return 0;
        return places.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.place_thumbnail)
        ImageView placeThumbnail;

        @BindView(R.id.place_title)
        TextView placeTitle;

        @BindView(R.id.place_type)
        TextView placeType;

        @BindView(R.id.place_rating)
        TextView placeRating;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            itemClickListener.onClick(places.get(position));
        }

    }

    public void setPlaces(List<Place> places) {
        this.places = places;
        notifyDataSetChanged();
    }
}
