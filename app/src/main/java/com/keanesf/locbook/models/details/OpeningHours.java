
package com.keanesf.locbook.models.details;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OpeningHours implements Parcelable
{

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;
    @SerializedName("periods")
    @Expose
    @Valid
    private List<Period> periods = null;
    @SerializedName("weekday_text")
    @Expose
    @Valid
    private List<String> weekdayText = null;
    public final static Creator<OpeningHours> CREATOR = new Creator<OpeningHours>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OpeningHours createFromParcel(Parcel in) {
            return new OpeningHours(in);
        }

        public OpeningHours[] newArray(int size) {
            return (new OpeningHours[size]);
        }

    }
    ;

    protected OpeningHours(Parcel in) {
        this.openNow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.periods, (com.keanesf.locbook.models.details.Period.class.getClassLoader()));
        in.readList(this.weekdayText, (String.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpeningHours() {
    }

    /**
     * 
     * @param weekdayText
     * @param periods
     * @param openNow
     */
    public OpeningHours(Boolean openNow, List<Period> periods, List<String> weekdayText) {
        super();
        this.openNow = openNow;
        this.periods = periods;
        this.weekdayText = weekdayText;
    }

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("openNow", openNow).append("periods", periods).append("weekdayText", weekdayText).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(weekdayText).append(periods).append(openNow).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OpeningHours) == false) {
            return false;
        }
        OpeningHours rhs = ((OpeningHours) other);
        return new EqualsBuilder().append(weekdayText, rhs.weekdayText).append(periods, rhs.periods).append(openNow, rhs.openNow).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(openNow);
        dest.writeList(periods);
        dest.writeList(weekdayText);
    }

    public int describeContents() {
        return  0;
    }

}
