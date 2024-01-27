package com.example.hasofoodapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.CartAdapter;
import com.example.hasofoodapp.models.CartModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.example.hasofoodapp.models.CartResponse;
import com.example.hasofoodapp.network.ApiService;
import com.example.hasofoodapp.network.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MyCartFragment extends Fragment {


    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;

    int total = 0 ;


    public MyCartFragment() {
        // Required empty public constructor
    }
    public void updateTotal() {
        int total = calculateTotal();
        TextView totalTextView = getView().findViewById(R.id.total);
        totalTextView.setText(String.valueOf(total));
    }





    // New method to calculate the total without formatting the string
    private int calculateTotal() {
        int total = 0;
        for (CartModel item : list) {
            total += item.getPrice()* item.getQuantity();
        }
        return total;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        // Call the API to get the cart items
        viewCart();

        cartAdapter = new CartAdapter(list, this);
        recyclerView.setAdapter(cartAdapter);

        return view;
    }

    private void viewCart() {
        ApiService apiService = RetrofitClient.getApiService().create(ApiService.class);

        Call<CartResponse> viewCartCall = apiService.viewCart(2); // Hardcoding userID for now

        viewCartCall.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    CartResponse cartResponse = response.body();
                    if (cartResponse != null) {
                        // Update your list and notify the adapter
                        list.clear(); // Clear existing items
                        list.addAll(cartResponse.getItems()); // Add new items
                        cartAdapter.notifyDataSetChanged(); // Notify the adapter
                        updateTotal();
                    }
                } else {
                    // Handle the unsuccessful response
                    Toast.makeText(getActivity(), "Failed ViewCart", Toast.LENGTH_SHORT).show();
                    // Show an error message or retry logic
                }
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                // Handle failure (network error, timeout, etc.)
                // Show an error message or retry logic
                Toast.makeText(getActivity(), "Failure on ViewCart", Toast.LENGTH_SHORT).show();
            }
        });
    }

}