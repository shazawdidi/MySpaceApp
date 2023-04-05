package com.task_test.myspaceapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: shazawdidi
 * @Date: 4/1/2023
 */
public class CompaniesResponse {

    @SerializedName("error")
     private String error;

    @SerializedName("status")
     private String status;

    @SerializedName("locationData")
     private List<LocationData> locationData=null;






    public String getError() {
        return error;
    }

    public List<LocationData> getLocationData() {
        return locationData;
    }

    public String getStatus() {
        return status;
    }
}
