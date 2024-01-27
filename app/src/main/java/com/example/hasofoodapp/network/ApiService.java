package com.example.hasofoodapp.network;

import com.example.hasofoodapp.models.AddToCartRequest;
import com.example.hasofoodapp.models.HomeHorModel;
import com.example.hasofoodapp.models.HomeVerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/catalogue/students/restaurant_list")
    Call<List<HomeHorModel>> getRestaurantList();

    @GET("/api/catalogue/students/item_list/{restaurantId}")
    Call<List<HomeVerModel>> getItemsForRestaurant(@Path("restaurantId") int restaurantId);


    @POST("/api/catalogue/students/add_cart")
    Call<Void> addToCart(@Body AddToCartRequest request);


}