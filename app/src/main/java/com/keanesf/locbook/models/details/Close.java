
package com.keanesf.locbook.models.details;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Close implements Parcelable
{

    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("time")
    @Expose
    private String time;
    public final static Creator<Close> CREATOR = new Creator<Close>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Close createFromParcel(Parcel in) {
            return new Close(in);
        }

        public Close[] newArray(int size) {
            return (new Close[size]);
        }

    }
    ;

    protected Close(Parcel in) {
        this.day = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Close() {
    }

    /**
     * 
     * @param time
     * @param day
     */
    public Close(Integer day, String time) {
        super();
        this.day = day;
        this.time = time;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("day", day).append("time", time).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(time).append(day).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Close) == false) {
            return false;
        }
        Close rhs = ((Close) other);
        return new EqualsBuilder().append(time, rhs.time).append(day, rhs.day).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(day);
        dest.writeValue(time);
    }

    public int describeContents() {
        return  0;
    }

}
