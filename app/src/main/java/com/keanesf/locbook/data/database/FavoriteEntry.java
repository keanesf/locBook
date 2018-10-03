package com.keanesf.locbook.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Defines the schema of a table in {@link Room} for a single favorite.
 * The date is used as an {@link Index} so that its uniqueness can be ensured. Indexes
 * also allow for fast lookup for the column.
 */
@Entity(tableName = "favorite", indices = {@Index(value = {"id"}, unique = true)})
public class FavoriteEntry {

    @PrimaryKey
    @NonNull
    private String id;

    // Constructor used by Room to create FavoriteEntries
    public FavoriteEntry(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
