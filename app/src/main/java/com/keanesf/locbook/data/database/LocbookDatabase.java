package com.keanesf.locbook.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

/**
 * {@link LocbookDatabase} database for the application including a table for {@link FavoriteEntry}
 * with the DAO {@link FavoriteDao}.
 */

@Database(entities = {FavoriteEntry.class}, version = 2)
public abstract class LocbookDatabase extends RoomDatabase {

    private static final String LOG_TAG = LocbookDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "favorite";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static LocbookDatabase sInstance;

    public static LocbookDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        LocbookDatabase.class, LocbookDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    // The associated DAOs for the database
    public abstract FavoriteDao favoriteDao();
}
