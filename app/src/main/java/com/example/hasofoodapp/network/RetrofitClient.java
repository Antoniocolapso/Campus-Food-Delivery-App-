package com.example.hasofoodapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
//    private static final String BASE_URL = "http://127.0.0.1:8000"; // Your base URL
    private static final String BASE_URL = "https://4b81-117-250-135-233.ngrok-free.app/"; // Your base URL
    private static Retrofit retrofit = null;

    public static Retrofit getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
