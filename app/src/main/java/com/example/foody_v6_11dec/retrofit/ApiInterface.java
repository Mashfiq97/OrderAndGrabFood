package com.example.foody_v6_11dec.retrofit;
import com.example.foody_v6_11dec.example.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();


    // lets make our model class of json data.

}
