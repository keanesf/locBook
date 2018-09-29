
package com.keanesf.locbook.models.details;

import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Period implements Parcelable
{

    @SerializedName("close")
    @Expose
    @Valid
    private Close close;
    @SerializedName("open")
    @Expose
    @Valid
    private Open open;
    public final static Creator<Period> CREATOR = new Creator<Period>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Period createFromParcel(Parcel in) {
            return new Period(in);
        }

        public Period[] newArray(int size) {
            return (new Period[size]);
        }

    }
    ;

    protected Period(Parcel in) {
        this.close = ((Close) in.readValue((Close.class.getClassLoader())));
        this.open = ((Open) in.readValue((Open.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Period() {
    }

    /**
     * 
     * @param open
     * @param close
     */
    public Period(Close close, Open open) {
        super();
        this.close = close;
        this.open = open;
    }

    public Close getClose() {
        return close;
    }

    public void setClose(Close close) {
        this.close = close;
    }

    public Open getOpen() {
        return open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("close", close).append("open", open).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(open).append(close).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Period) == false) {
            return false;
        }
        Period rhs = ((Period) other);
        return new EqualsBuilder().append(open, rhs.open).append(close, rhs.close).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(close);
        dest.writeValue(open);
    }

    public int describeContents() {
        return  0;
    }

}
