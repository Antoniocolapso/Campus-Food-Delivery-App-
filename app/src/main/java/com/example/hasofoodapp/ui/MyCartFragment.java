package com.example.hasofoodapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        list.add(new CartModel(R.drawable.s1,"Order 1", 30,"4.2",1));
        list.add(new CartModel(R.drawable.s2,"Order 2", 50,"4.2",2));
        list.add(new CartModel(R.drawable.fav1,"Order 3", 120,"4.2",3));
        list.add(new CartModel(R.drawable.s1,"Order 4", 30,"4.2",2));
        list.add(new CartModel(R.drawable.s2,"Order 5", 50,"4.2",3));
        list.add(new CartModel(R.drawable.fav1,"Order 6", 130,"4.2",4));


//        int total = 0, i = 0;
//
//        for (i = 0; i < list.size(); i++) {
//            total = total + (list.get(i).getPrice() * list.get(i).getQuantity());
//        }
        cartAdapter = new CartAdapter(list,this);
        recyclerView.setAdapter(cartAdapter);







        return view;
    }
}