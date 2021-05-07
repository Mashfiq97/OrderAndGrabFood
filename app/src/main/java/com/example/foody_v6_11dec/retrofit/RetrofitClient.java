package com.example.foody_v6_11dec.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    //private static final String BASE_URL = "https://foodorderingappv6.000webhostapp.com/";
    private static final String BASE_URL = "https://raw.githubusercontent.com/Mashfiq97/foodapp/main/";

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
