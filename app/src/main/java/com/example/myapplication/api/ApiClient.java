package com.example.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String URL_BASE = "https://antree.bentran1vn.xyz/api/v1/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
