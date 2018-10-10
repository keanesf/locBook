package com.keanesf.locbook.data.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.keanesf.locbook.models.common.Photo;

import java.lang.reflect.Type;
import java.util.List;

public class PhotoTypeConverters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Photo> fromString(String value) {
        Type listType = new TypeToken<List<Photo>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromPhotoList(List<Photo> photos) {
        return gson.toJson(photos);
    }

}

