package com.task_test.myspaceapp.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.task_test.myspaceapp.data.ApiService;
import com.task_test.myspaceapp.data.RetrofitRequest;
import com.task_test.myspaceapp.model.CompaniesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author: shazawdidi
 * @Date: 4/1/2023
 */
public class CompanyRepository {
    private static final String TAG = CompanyRepository.class.getSimpleName();
    private ApiService apiRequest;

    public CompanyRepository() {
        apiRequest = RetrofitRequest.getClient().create(ApiService.class);
    }
    public LiveData<CompaniesResponse> getCompanyMark(String query, String key) {
        final MutableLiveData<CompaniesResponse> data = new MutableLiveData<>();
        apiRequest.getCompanyMarker(query, key)
                .enqueue(new Callback<CompaniesResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CompaniesResponse> call, @NonNull Response<CompaniesResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d(TAG, "CompaniesMarkerData:: " + response.body().getLocationData().toString());
                            Log.d(TAG, "STATUS CODE:: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<CompaniesResponse> call, Throwable t) {
                        Log.d(TAG, "Error:: " + t);
                        data.setValue(null);
                    }
                });
        return data;
    }
}
