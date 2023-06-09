package com.task_test.myspaceapp.data;

import com.task_test.myspaceapp.model.CompaniesResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * @Author: shazawdidi
 * @Date: 4/1/2023
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("api/msDiscoverPage")
    Call<CompaniesResponse> getCompanyMarker(
            @Field("searchText") String searchText,
            @Field("apiKey") String apiKey
    );
 }
