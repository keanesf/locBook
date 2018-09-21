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


import com.keanesf.locbook.R;
import com.keanesf.locbook.models.Place;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ItemViewHolder> {

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

        Context context = holder.itemView.getContext();
        String placeName = places.get(position).getName();
        holder.placeTitle.setText(placeName);

        // todo add photo

        String photoReference = null;
        if(places.get(position).getPhotos().size() > 0){
            photoReference = places.get(position).getPhotos().get(0).getPhotoReference();

        }

//        if (photoReference.equals("")) {
//            Picasso.with(context)
//                    .load(recipePic)
//                    .placeholder(R.drawable.image_placeholder)
//                    .error(R.drawable.image_placeholder)
//                    .into(holder.placeThumbnail);
//        } else {
//            Picasso.with(context)
//                    .load(imagePath)
//                    .placeholder(R.drawable.image_placeholder)
//                    .error(R.drawable.image_placeholder)
//                    .into(holder.placeThumbnail);
//        }
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
