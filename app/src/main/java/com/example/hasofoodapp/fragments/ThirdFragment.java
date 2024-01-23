package com.example.hasofoodapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.FeaturedAdapter;
import com.example.hasofoodapp.adapters.FeaturedVerAdapter;
import com.example.hasofoodapp.models.FeaturedModel;
import com.example.hasofoodapp.models.FeaturedVerModel;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {

    //////////////// Featured Hor Recycler View
    List<FeaturedModel> featuredModelList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    //////////////// Featured Ver Recycler View
    List<FeaturedVerModel> featuredVerModelList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        //////////////// Featured Ver Recycler View
        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        featuredVerModelList = new ArrayList<>();
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1,"Featured 1","Descriptiopn1","4.8", "10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2,"Featured 2","Descriptiopn1","4.8", "10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3,"Featured 3","Descriptiopn1","4.8", "10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1,"Featured 1","Descriptiopn1","4.8", "10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2,"Featured 2","Descriptiopn1","4.8", "10:00 - 19:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3,"Featured 3","Descriptiopn1","4.8", "10:00 - 19:00"));


        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);


        //////////////// Featured Hor Recycler View
        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModelList = new ArrayList<>();

        featuredModelList.add(new FeaturedModel(R.drawable.fav1,"Featured 1","Descriptiopn1"));
        featuredModelList.add(new FeaturedModel(R.drawable.fav2,"Featured 2","Descriptiopn1"));
        featuredModelList.add(new FeaturedModel(R.drawable.fav3,"Featured 3","Descriptiopn1"));

        featuredAdapter = new FeaturedAdapter(featuredModelList);
        recyclerView.setAdapter(featuredAdapter);

        return view;
    }
}