package com.example.helloworld.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://demo5736062.mockable.io/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
