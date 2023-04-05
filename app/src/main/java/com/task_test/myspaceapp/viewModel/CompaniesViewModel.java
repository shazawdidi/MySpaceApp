package com.task_test.myspaceapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.task_test.myspaceapp.model.CompaniesResponse;
import com.task_test.myspaceapp.repository.CompanyRepository;

/**
 * @Author: shazawdidi
 * @Date: 4/1/2023
 */
public class CompaniesViewModel extends AndroidViewModel {

    private CompanyRepository articleRepository;
    private LiveData<CompaniesResponse> articleResponseLiveData;


    public CompaniesViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new CompanyRepository();
        this.articleResponseLiveData = articleRepository.getCompanyMark("", "501edc9e");
    }

    public LiveData<CompaniesResponse> getCompanyResponseLiveData() {
        return articleResponseLiveData;
    }
}
