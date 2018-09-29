
package com.keanesf.locbook.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlusCode implements Parcelable
{

    @SerializedName("compound_code")
    @Expose
    private String compoundCode;
    @SerializedName("global_code")
    @Expose
    private String globalCode;
    public final static Creator<PlusCode> CREATOR = new Creator<PlusCode>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PlusCode createFromParcel(Parcel in) {
            return new PlusCode(in);
        }

        public PlusCode[] newArray(int size) {
            return (new PlusCode[size]);
        }

    }
    ;

    protected PlusCode(Parcel in) {
        this.compoundCode = ((String) in.readValue((String.class.getClassLoader())));
        this.globalCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlusCode() {
    }

    /**
     * 
     * @param compoundCode
     * @param globalCode
     */
    public PlusCode(String compoundCode, String globalCode) {
        super();
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public String getCompoundCode() {
        return compoundCode;
    }

    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("compoundCode", compoundCode).append("globalCode", globalCode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(compoundCode).append(globalCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlusCode) == false) {
            return false;
        }
        PlusCode rhs = ((PlusCode) other);
        return new EqualsBuilder().append(compoundCode, rhs.compoundCode).append(globalCode, rhs.globalCode).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(compoundCode);
        dest.writeValue(globalCode);
    }

    public int describeContents() {
        return  0;
    }

}
