package com.example.hasofoodapp.ui.Order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.OrderAdapter;
import com.example.hasofoodapp.models.OrderModel;

import java.util.ArrayList;
import java.util.List;

// OrderFragment.java
public class OrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private List<OrderModel> orderList;



        public OrderFragment() {
            // Required empty public constructor
        }

        @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewOrders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderList = new ArrayList<>();
        orderAdapter = new OrderAdapter(orderList);
        recyclerView.setAdapter(orderAdapter);

        // Fetch and display active orders
        fetchActiveOrders();
        fetchOrderHistory();
        return view;
    }

    private void fetchActiveOrders() {
        // Implement the API call to get active orders and update orderList
        // Use Retrofit or any other networking library
        // Example: ApiService.getActiveOrders(restaurantID)
    }

    private void fetchOrderHistory() {
        // Implement the API call to get order history and update orderList
        // Use Retrofit or any other networking library
        // Example: ApiService.getOrderHistory(restaurantID)
    }
}
