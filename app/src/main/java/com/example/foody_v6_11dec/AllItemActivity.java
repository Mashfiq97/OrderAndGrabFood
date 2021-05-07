package com.example.foody_v6_11dec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.foody_v6_11dec.example.Allmenu;
import com.example.foody_v6_11dec.example.FoodData;
import com.example.foody_v6_11dec.example.Popular;
import com.example.foody_v6_11dec.example.Recommended;
import com.example.foody_v6_11dec.retrofit.ApiInterface;
import com.example.foody_v6_11dec.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllItemActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_item);


        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);



        Call<List<FoodData>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {

                List<FoodData> foodDataList = response.body();

                getPopularData(foodDataList.get(0).getPopular());
                getRecommendedData(foodDataList.get(0).getRecommended());
                getAllMenu(foodDataList.get(0).getAllmenu());


            }

            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(AllItemActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recyclerAllItemActivity);
        popularAdapter = new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recyclerAllItemActivity);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }
    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recyclerAllItemActivity);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}