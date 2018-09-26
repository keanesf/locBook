package com.keanesf.locbook.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class ListViewService extends RemoteViewsService {

    @Override
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ListRemoteViewFactory(this.getApplicationContext());
    }
}
