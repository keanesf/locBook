package com.keanesf.locbook.widget;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.keanesf.locbook.R;
import com.keanesf.locbook.activities.PlaceDetailActivity;
import com.keanesf.locbook.models.Place;

import java.util.List;

public class ListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
    private List<Place> places;

    public ListRemoteViewsFactory(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        places = PlaceDetailActivity.places;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if (places == null) return 0;
        return places.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_list_view_item);
        remoteViews.setTextViewText(R.id.widget_list_view_text_ingredient, ingredients.get(i).getIngredient());
        remoteViews.setTextViewText(R.id.widget_list_view_text_measure, ingredients.get(i).getMeasure());
        remoteViews.setTextViewText(R.id.widget_list_view_text_quantity, ingredients.get(i).getQuantity() + "");
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
