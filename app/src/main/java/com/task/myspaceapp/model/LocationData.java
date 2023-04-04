package com.task.myspaceapp.model;

  import android.os.Parcel;
  import android.os.Parcelable;

  import androidx.annotation.NonNull;
  import androidx.annotation.Nullable;

  import com.google.android.gms.maps.model.LatLng;
  import com.google.gson.annotations.SerializedName;
  import com.google.maps.android.clustering.ClusterItem;

  import java.util.List;


public class LocationData implements Parcelable, ClusterItem {
    @SerializedName("addressOne")
    private String addressOne;

    @SerializedName("addressTwo")
    private String addressTwo;

    @SerializedName("avgRating")
    private String avgRating;

    @SerializedName("category")
    private String category;

    @SerializedName("companyType")
    private String companyType;

    @SerializedName("country")
    private String country;


    @SerializedName("id")
    private String id;


    @SerializedName("image")
    private String image;


    @SerializedName("latitude")
    private double latitude;


    @SerializedName("longitude")
    private double longitude;


    @SerializedName("name")
    private String name;


    @SerializedName("newJoined")
    private String newJoined;



    @SerializedName("rattingValues")
     private  List<RattingValue> rattingValues;

    @SerializedName("state")
    private String state;

    @SerializedName("totalRatingCount")
    private String totalRatingCount;


    @SerializedName("totalReview")
    private String totalReview;


    @SerializedName("userLocation")
    private String userLocation;

    private  LatLng mPosition;


    protected LocationData(Parcel in) {
        addressOne = in.readString();
        addressTwo = in.readString();
        avgRating = in.readString();
        category = in.readString();
        companyType = in.readString();
        country = in.readString();
        id = in.readString();
        image = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        name = in.readString();
        newJoined = in.readString();
        state = in.readString();
        totalRatingCount = in.readString();
        totalReview = in.readString();
        userLocation = in.readString();
    }
    public LocationData(double lat, double lng, String title, String snippet) {
        mPosition = new LatLng(lat, lng);
        name = title;
        image = snippet;
    }
    public LocationData(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
        name = null;
        image = null;
    }

    public static final Creator<LocationData> CREATOR = new Creator<LocationData>() {
        @Override
        public LocationData createFromParcel(Parcel in) {
            return new LocationData(in);
        }

        @Override
        public LocationData[] newArray(int size) {
            return new LocationData[size];
        }
    };

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public String getCategory() {
        return category;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getNewJoined() {
        return newJoined;
    }

    public List<RattingValue> getRattingValues() {
        return rattingValues;
    }

    public String getState() {
        return state;
    }

    public String getTotalRatingCount() {
        return totalRatingCount;
    }

    public String getTotalReview() {
        return totalReview;
    }

    public String getUserLocation() {
        return userLocation;
    }


    @Override
    public String toString(){
        return
                "Companies{" +
                        "addressOne = '" + addressOne + '\'' +
                        ",addressTwo = '" + addressTwo + '\'' +
                        ",avgRating = '" + avgRating + '\'' +
                        ",category = '" + category + '\'' +
                        ",companyType = '" + companyType + '\'' +
                        ",country = '" + country + '\'' +
                        ",id = '" + id + '\'' +
                        ",image = '" + image + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        ",name = '" + name + '\'' +
                        ",newJoined = '" + newJoined + '\'' +
                        ",state = '" + state + '\'' +
                        ",totalRatingCount = '" + totalRatingCount + '\'' +
                        ",totalReview = '" + totalReview + '\'' +
                        ",userLocation = '" + userLocation + '\'' +
                        "}";
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel( Parcel dest, int i) {
        dest.writeTypedList(rattingValues);
        dest.writeString(name);
        dest.writeString(id);
    }

    @NonNull
    @Override
    public LatLng getPosition() {
        return null;
    }

    @Nullable
    @Override
    public String getTitle() {
        return null;
    }

    @Nullable
    @Override
    public String getSnippet() {
        return null;
    }
}
