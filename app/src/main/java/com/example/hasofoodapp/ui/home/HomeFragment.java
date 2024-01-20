package com.example.hasofoodapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.HomeHorAdapter;
import com.example.hasofoodapp.adapters.HomeVerAdapter;
import com.example.hasofoodapp.adapters.UpdateVerticalRec;
import com.example.hasofoodapp.databinding.FragmentHomeBinding;
import com.example.hasofoodapp.models.HomeHorModel;
import com.example.hasofoodapp.models.HomeVerModel;

import java.util.ArrayList;



public class HomeFragment extends Fragment  implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    /////////////////////////////////vertical list
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);


        ////////////////////////////// Vertical Recycler View
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        
        ////////////////////////////// Horizontal Recycler View
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add((new HomeHorModel(R.drawable.pizza1,"Pizza")));
        homeHorModelList.add((new HomeHorModel(R.drawable.burger1,"Burger")));
        homeHorModelList.add((new HomeHorModel(R.drawable.fries1,"Fries")));
        homeHorModelList.add((new HomeHorModel(R.drawable.icecream1,"IceCream")));
        homeHorModelList.add((new HomeHorModel(R.drawable.sandwich1,"Sandwich")));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter =new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}