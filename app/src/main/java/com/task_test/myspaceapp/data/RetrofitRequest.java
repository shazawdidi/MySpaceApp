package com.task_test.myspaceapp.data;

/**
 * @Author: shazawdidi
 * @Date: 4/1/2023
 */

import static com.task_test.myspaceapp.util.Constants.BASE_URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitRequest {


    public static Retrofit getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        List<Protocol> protocols = new ArrayList<>();
        protocols.add(Protocol.HTTP_1_1);
        protocols.add(Protocol.HTTP_2);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder builder = original.newBuilder().method(original.method(), original.body());
                    return chain.proceed(builder.build());

                })
                .addInterceptor(chain -> {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                            .addHeader("Cookie", "ci_session=e25515df3333ebe00991ff840e694d938c0fc3e7")
                            .build();
                    return chain.proceed(newRequest);
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .protocols(protocols)
                //.connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS))
                .build();


        Gson gson = new GsonBuilder()
                .setLenient().setLenient()
                .serializeNulls()
                .create();


        return new Retrofit.
                Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


    }


}