package com.example.hasofoodapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.CartAdapter;
import com.example.hasofoodapp.models.CartModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {


    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;



    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        list.add(new CartModel(R.drawable.s1,"Order 1", "Rs. 30","4.2"));
        list.add(new CartModel(R.drawable.s2,"Order 2", "Rs. 50","4.2"));
        list.add(new CartModel(R.drawable.fav1,"Order 3", "Rs. 130","4.2"));
        list.add(new CartModel(R.drawable.s1,"Order 4", "Rs. 30","4.2"));
        list.add(new CartModel(R.drawable.s2,"Order 5", "Rs. 50","4.2"));
        list.add(new CartModel(R.drawable.fav1,"Order 6", "Rs. 130","4.2"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);

        return view;
    }
}