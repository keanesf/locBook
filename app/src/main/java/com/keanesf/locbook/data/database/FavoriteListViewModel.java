package com.keanesf.locbook.data.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class FavoriteListViewModel extends AndroidViewModel {

    private final LiveData<List<FavoriteEntry>> favoriteEntries;

    private LocbookDatabase locbookDatabase;

    public FavoriteListViewModel(Application application){
        super(application);

        locbookDatabase = LocbookDatabase.getInstance(this.getApplication());

        favoriteEntries = locbookDatabase.favoriteDao().getAll();
    }

    public LiveData<List<FavoriteEntry>> getFavoriteEntries() {
        return favoriteEntries;
    }
}