package com.dlsu.joshua;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class EnlistMeService {
    private static final String BASE_URL = "http://127.0.0.1:5000";
    private EnlistMeAPI api;

    public EnlistMeService() {
        // Configure OkHttpClient with extended timeout values
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)  // Set connection timeout
                .readTimeout(60, TimeUnit.SECONDS)     // Set read timeout
                .writeTimeout(60, TimeUnit.SECONDS)    // Set write timeout
                .build();

        // Initialize Retrofit with the configured OkHttpClient
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(EnlistMeAPI.class);
    }

    public EnlistMeAPI getApi() {
        return api;
    }
}