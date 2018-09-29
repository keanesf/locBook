
package com.keanesf.locbook.models.details;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Review implements Parcelable
{

    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("author_url")
    @Expose
    private String authorUrl;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("profile_photo_url")
    @Expose
    private String profilePhotoUrl;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("relative_time_description")
    @Expose
    private String relativeTimeDescription;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("time")
    @Expose
    private Integer time;
    public final static Creator<Review> CREATOR = new Creator<Review>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        public Review[] newArray(int size) {
            return (new Review[size]);
        }

    }
    ;

    protected Review(Parcel in) {
        this.authorName = ((String) in.readValue((String.class.getClassLoader())));
        this.authorUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.profilePhotoUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.relativeTimeDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Review() {
    }

    /**
     * 
     * @param time
     * @param text
     * @param profilePhotoUrl
     * @param authorName
     * @param authorUrl
     * @param rating
     * @param language
     * @param relativeTimeDescription
     */
    public Review(String authorName, String authorUrl, String language, String profilePhotoUrl, Integer rating, String relativeTimeDescription, String text, Integer time) {
        super();
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.language = language;
        this.profilePhotoUrl = profilePhotoUrl;
        this.rating = rating;
        this.relativeTimeDescription = relativeTimeDescription;
        this.text = text;
        this.time = time;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRelativeTimeDescription() {
        return relativeTimeDescription;
    }

    public void setRelativeTimeDescription(String relativeTimeDescription) {
        this.relativeTimeDescription = relativeTimeDescription;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authorName", authorName).append("authorUrl", authorUrl).append("language", language).append("profilePhotoUrl", profilePhotoUrl).append("rating", rating).append("relativeTimeDescription", relativeTimeDescription).append("text", text).append("time", time).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(time).append(text).append(profilePhotoUrl).append(authorName).append(authorUrl).append(rating).append(language).append(relativeTimeDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Review) == false) {
            return false;
        }
        Review rhs = ((Review) other);
        return new EqualsBuilder().append(time, rhs.time).append(text, rhs.text).append(profilePhotoUrl, rhs.profilePhotoUrl).append(authorName, rhs.authorName).append(authorUrl, rhs.authorUrl).append(rating, rhs.rating).append(language, rhs.language).append(relativeTimeDescription, rhs.relativeTimeDescription).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(authorName);
        dest.writeValue(authorUrl);
        dest.writeValue(language);
        dest.writeValue(profilePhotoUrl);
        dest.writeValue(rating);
        dest.writeValue(relativeTimeDescription);
        dest.writeValue(text);
        dest.writeValue(time);
    }

    public int describeContents() {
        return  0;
    }

}
