package com.keanesf.locbook.widget;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.keanesf.locbook.R;
import com.keanesf.locbook.activities.PlaceDetailActivity;
import com.keanesf.locbook.models.details.Place;

import java.util.ArrayList;
import java.util.List;

public class ListRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
    private List<Place> modelList = new ArrayList<>();

    public ListRemoteViewFactory(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        modelList.add(PlaceDetailActivity.place);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if (modelList == null) return 0;
        return modelList.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_list_view_item);
        remoteViews.setTextViewText(R.id.widget_list_view_text_rating, modelList.get(i).getRating().toString());
        remoteViews.setTextViewText(R.id.widget_list_view_text_type, modelList.get(i).getTypes().get(0));
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
