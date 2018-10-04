package com.keanesf.locbook.widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.keanesf.locbook.R;
import com.keanesf.locbook.activities.PlaceDetailActivity;
import com.keanesf.locbook.fragments.PlaceDetailFragment;

public class PlaceService extends IntentService {

    public static final String ACTION_CHANGE_PLACE_LIST =
            "com.keanesf.locbook.widget.action.change_list";

    public PlaceService() {
        super("PlaceService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CHANGE_PLACE_LIST.equals(action)) {
                handleActionChangePlace();
            }
        }
    }

    public static boolean startActionChangePlace(Context context) {
        Intent intent = new Intent(context, PlaceService.class);
        intent.setAction(ACTION_CHANGE_PLACE_LIST);

        // a temporary solution for Android 8.0
        try {
            context.startService(intent);
            return true;
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void handleActionChangePlace() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(
                new ComponentName(this, PlaceWidgetProvider.class));
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_list_view);
        PlaceWidgetProvider.updatePlaceWidgets(
                this, appWidgetManager, PlaceDetailActivity.placeTitle, appWidgetIds);
    }
}
