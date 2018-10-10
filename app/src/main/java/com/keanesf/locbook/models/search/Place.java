
package com.keanesf.locbook.models.search;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.keanesf.locbook.models.common.Photo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Place implements Parcelable
{

    @SerializedName("geometry")
    @Expose
    @Valid
    private Geometry geometry;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photos")
    @Expose
    @Valid
    private List<Photo> photos = null;
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("plus_code")
    @Expose
    @Valid
    private PlusCode plusCode;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("types")
    @Expose
    @Valid
    private List<String> types = null;
    @SerializedName("vicinity")
    @Expose
    private String vicinity;
    public final static Creator<Place> CREATOR = new Creator<Place>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return (new Place[size]);
        }

    }
    ;

    protected Place(Parcel in) {
        this.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
        this.icon = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.photos, (Photo.class.getClassLoader()));
        this.placeId = ((String) in.readValue((String.class.getClassLoader())));
        this.plusCode = ((PlusCode) in.readValue((PlusCode.class.getClassLoader())));
        this.rating = ((Double) in.readValue((Double.class.getClassLoader())));
        this.reference = ((String) in.readValue((String.class.getClassLoader())));
        this.scope = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.types, (String.class.getClassLoader()));
        this.vicinity = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Place() {
    }

    /**
     * 
     * @param photos
     * @param id
     * @param icon
     * @param vicinity
     * @param scope
     * @param placeId
     * @param name
     * @param plusCode
     * @param rating
     * @param types
     * @param reference
     * @param geometry
     */
    public Place(Geometry geometry, String icon, String id, String name, List<Photo> photos, String placeId, PlusCode plusCode, Double rating, String reference, String scope, List<String> types, String vicinity) {
        super();
        this.geometry = geometry;
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.photos = photos;
        this.placeId = placeId;
        this.plusCode = plusCode;
        this.rating = rating;
        this.reference = reference;
        this.scope = scope;
        this.types = types;
        this.vicinity = vicinity;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("geometry", geometry).append("icon", icon).append("id", id).append("name", name).append("photos", photos).append("placeId", placeId).append("plusCode", plusCode).append("rating", rating).append("reference", reference).append("scope", scope).append("types", types).append("vicinity", vicinity).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(icon).append(scope).append(plusCode).append(reference).append(geometry).append(photos).append(id).append(vicinity).append(placeId).append(name).append(rating).append(types).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Place) == false) {
            return false;
        }
        Place rhs = ((Place) other);
        return new EqualsBuilder().append(icon, rhs.icon).append(scope, rhs.scope).append(plusCode, rhs.plusCode).append(reference, rhs.reference).append(geometry, rhs.geometry).append(photos, rhs.photos).append(id, rhs.id).append(vicinity, rhs.vicinity).append(placeId, rhs.placeId).append(name, rhs.name).append(rating, rhs.rating).append(types, rhs.types).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(geometry);
        dest.writeValue(icon);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeList(photos);
        dest.writeValue(placeId);
        dest.writeValue(plusCode);
        dest.writeValue(rating);
        dest.writeValue(reference);
        dest.writeValue(scope);
        dest.writeList(types);
        dest.writeValue(vicinity);
    }

    public int describeContents() {
        return  0;
    }

}
