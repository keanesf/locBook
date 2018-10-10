
package com.keanesf.locbook.models.details;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.keanesf.locbook.models.common.Photo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Place implements Parcelable
{

    @SerializedName("address_components")
    @Expose
    @Valid
    private List<AddressComponent> addressComponents = null;
    @SerializedName("adr_address")
    @Expose
    private String adrAddress;
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;
    @SerializedName("formatted_phone_number")
    @Expose
    private String formattedPhoneNumber;
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
    @SerializedName("international_phone_number")
    @Expose
    private String internationalPhoneNumber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("opening_hours")
    @Expose
    @Valid
    private OpeningHours openingHours;
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
    @SerializedName("reviews")
    @Expose
    @Valid
    private List<Review> reviews = null;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("types")
    @Expose
    @Valid
    private List<String> types = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("vicinity")
    @Expose
    private String vicinity;
    @SerializedName("website")
    @Expose
    private String website;
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
        in.readList(this.addressComponents, (AddressComponent.class.getClassLoader()));
        this.adrAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.formattedAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.formattedPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
        this.icon = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.internationalPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.openingHours = ((OpeningHours) in.readValue((OpeningHours.class.getClassLoader())));
        in.readList(this.photos, (Photo.class.getClassLoader()));
        this.placeId = ((String) in.readValue((String.class.getClassLoader())));
        this.plusCode = ((PlusCode) in.readValue((PlusCode.class.getClassLoader())));
        this.rating = ((Double) in.readValue((Double.class.getClassLoader())));
        this.reference = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.reviews, (com.keanesf.locbook.models.details.Review.class.getClassLoader()));
        this.scope = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.types, (String.class.getClassLoader()));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.utcOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vicinity = ((String) in.readValue((String.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Place() {
    }

    /**
     *
     * @param icon
     * @param reviews
     * @param scope
     * @param website
     * @param openingHours
     * @param plusCode
     * @param adrAddress
     * @param url
     * @param reference
     * @param geometry
     * @param internationalPhoneNumber
     * @param id
     * @param photos
     * @param vicinity
     * @param formattedPhoneNumber
     * @param placeId
     * @param name
     * @param utcOffset
     * @param formattedAddress
     * @param rating
     * @param types
     * @param addressComponents
     */
    public Place(List<AddressComponent> addressComponents, String adrAddress, String formattedAddress, String formattedPhoneNumber, Geometry geometry, String icon, String id, String internationalPhoneNumber, String name, OpeningHours openingHours, List<Photo> photos, String placeId, PlusCode plusCode, Double rating, String reference, List<Review> reviews, String scope, List<String> types, String url, Integer utcOffset, String vicinity, String website) {
        super();
        this.addressComponents = addressComponents;
        this.adrAddress = adrAddress;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.geometry = geometry;
        this.icon = icon;
        this.id = id;
        this.internationalPhoneNumber = internationalPhoneNumber;
        this.name = name;
        this.openingHours = openingHours;
        this.photos = photos;
        this.placeId = placeId;
        this.plusCode = plusCode;
        this.rating = rating;
        this.reference = reference;
        this.reviews = reviews;
        this.scope = scope;
        this.types = types;
        this.url = url;
        this.utcOffset = utcOffset;
        this.vicinity = vicinity;
        this.website = website;
    }

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
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

    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.internationalPhoneNumber = internationalPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("addressComponents", addressComponents).append("adrAddress", adrAddress).append("formattedAddress", formattedAddress).append("formattedPhoneNumber", formattedPhoneNumber).append("geometry", geometry).append("icon", icon).append("id", id).append("internationalPhoneNumber", internationalPhoneNumber).append("name", name).append("openingHours", openingHours).append("photos", photos).append("placeId", placeId).append("plusCode", plusCode).append("rating", rating).append("reference", reference).append("reviews", reviews).append("scope", scope).append("types", types).append("url", url).append("utcOffset", utcOffset).append("vicinity", vicinity).append("website", website).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(icon).append(reviews).append(scope).append(website).append(openingHours).append(plusCode).append(adrAddress).append(url).append(reference).append(internationalPhoneNumber).append(geometry).append(photos).append(id).append(vicinity).append(placeId).append(formattedPhoneNumber).append(name).append(utcOffset).append(formattedAddress).append(rating).append(types).append(addressComponents).toHashCode();
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
        return new EqualsBuilder().append(icon, rhs.icon).append(reviews, rhs.reviews).append(scope, rhs.scope).append(website, rhs.website).append(openingHours, rhs.openingHours).append(plusCode, rhs.plusCode).append(adrAddress, rhs.adrAddress).append(url, rhs.url).append(reference, rhs.reference).append(internationalPhoneNumber, rhs.internationalPhoneNumber).append(geometry, rhs.geometry).append(photos, rhs.photos).append(id, rhs.id).append(vicinity, rhs.vicinity).append(placeId, rhs.placeId).append(formattedPhoneNumber, rhs.formattedPhoneNumber).append(name, rhs.name).append(utcOffset, rhs.utcOffset).append(formattedAddress, rhs.formattedAddress).append(rating, rhs.rating).append(types, rhs.types).append(addressComponents, rhs.addressComponents).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(addressComponents);
        dest.writeValue(adrAddress);
        dest.writeValue(formattedAddress);
        dest.writeValue(formattedPhoneNumber);
        dest.writeValue(geometry);
        dest.writeValue(icon);
        dest.writeValue(id);
        dest.writeValue(internationalPhoneNumber);
        dest.writeValue(name);
        dest.writeValue(openingHours);
        dest.writeList(photos);
        dest.writeValue(placeId);
        dest.writeValue(plusCode);
        dest.writeValue(rating);
        dest.writeValue(reference);
        dest.writeList(reviews);
        dest.writeValue(scope);
        dest.writeList(types);
        dest.writeValue(url);
        dest.writeValue(utcOffset);
        dest.writeValue(vicinity);
        dest.writeValue(website);
    }

    public int describeContents() {
        return  0;
    }

}
