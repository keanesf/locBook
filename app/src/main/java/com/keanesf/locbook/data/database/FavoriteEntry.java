package com.keanesf.locbook.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.keanesf.locbook.models.common.Photo;

import java.util.List;

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

    private String name;

    private Double rating;

    @TypeConverters({PlaceTypeConverters.class})
    private List<String> types;

    @TypeConverters({PhotoTypeConverters.class})
    private List<Photo> photos;

    // Constructor used by Room to create FavoriteEntries
    public FavoriteEntry(@NonNull String id, String name, Double rating,
                         List<String> types, List<Photo> photos)
    {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.types = types;
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
