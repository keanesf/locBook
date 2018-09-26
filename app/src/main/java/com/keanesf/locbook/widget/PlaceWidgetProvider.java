package com.keanesf.locbook.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.keanesf.locbook.R;

public class PlaceWidgetProvider extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, String recipeName, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.place_widget);
        views.setTextViewText(R.id.appwidget_text, recipeName);
        Intent intent = new Intent(context, ListViewService.class);
        views.setRemoteAdapter(R.id.widget_list_view, intent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        PlaceService.startActionChangePlaceList(context);
    }

    public static void updatePlaceWidgets(Context context, AppWidgetManager appWidgetManager, String recipeName, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, recipeName, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}
