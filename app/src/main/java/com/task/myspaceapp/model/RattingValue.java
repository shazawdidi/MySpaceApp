package com.task.myspaceapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


public class RattingValue implements Parcelable {
    @SerializedName("ratingPercentage")
    private String ratingPercentage;

    @SerializedName("rattingLable")
    private String rattingLable;

    @SerializedName("rattingValue")
    private String rattingValue;

    protected RattingValue(Parcel in) {
        ratingPercentage = in.readString();
        rattingLable = in.readString();
        rattingValue = in.readString();
    }

    public static final Creator<RattingValue> CREATOR = new Creator<RattingValue>() {
        @Override
        public RattingValue createFromParcel(Parcel in) {
            return new RattingValue(in);
        }

        @Override
        public RattingValue[] newArray(int size) {
            return new RattingValue[size];
        }
    };

    public String getRatingPercentage() {
        return ratingPercentage;
    }

    public String getRattingLable() {
        return rattingLable;
    }

    public String getRattingValue() {
        return rattingValue;
    }

    @Override
    public String toString(){
        return
                "ProductsItem{" +
                        "ratingPercentage = '" + ratingPercentage + '\'' +
                        ",rattingLable = '" + rattingLable + '\'' +
                        ",rattingValue = '" + rattingValue + '\'' +
                        "}";
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(ratingPercentage);
        parcel.writeString(rattingLable);
        parcel.writeString(rattingValue);
    }
}
