package com.example.hasofoodapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.hasofoodapp.network.ApiService;
import com.example.hasofoodapp.network.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements UpdateVerticalRec, HomeHorAdapter.RestaurantClickListener {

    private RecyclerView homeHorizontalRec, homeVerticalRec;
    private ArrayList<HomeHorModel> homeHorModelList;
    private HomeHorAdapter homeHorAdapter;
    private ArrayList<HomeVerModel> homeVerModelList;
    private HomeVerAdapter homeVerAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        homeVerModelList = new ArrayList<>();
        homeVerAdapter = new HomeVerAdapter(getContext(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        homeHorModelList = new ArrayList<>();
        homeHorAdapter = new HomeHorAdapter(this, getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        Retrofit retrofit = RetrofitClient.getApiService();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<HomeHorModel>> call = apiService.getRestaurantList();

        call.enqueue(new Callback<List<HomeHorModel>>() {
            @Override
            public void onResponse(Call<List<HomeHorModel>> call, Response<List<HomeHorModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<HomeHorModel> restaurants = response.body();
                    for (HomeHorModel restaurant : restaurants) {
                        homeHorModelList.add(new HomeHorModel(restaurant.getImageUrl(), restaurant.getName(), restaurant.getRestaurantId()));
                    }

                    homeHorAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "Failed to fetch restaurant data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HomeHorModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(), list);
        homeVerticalRec.setAdapter(homeVerAdapter);
    }

    @Override
    public void onRestaurantClick(int restaurantId) {
        // Fetch items for the selected restaurant ID and update the vertical recycler view
        fetchItemsForRestaurant(restaurantId);
    }

    private void fetchItemsForRestaurant(int restaurantId) {
        Retrofit retrofit = RetrofitClient.getApiService();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<HomeVerModel>> call = apiService.getItemsForRestaurant(restaurantId);

        call.enqueue(new Callback<List<HomeVerModel>>() {
            @Override
            public void onResponse(Call<List<HomeVerModel>> call, Response<List<HomeVerModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Process the response and update homeVerModelList
                    List<HomeVerModel> items = response.body();
                    homeVerModelList.clear();
                    homeVerModelList.addAll(items);
                    homeVerAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "Failed to fetch items for the restaurant" + restaurantId, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HomeVerModel>> call, Throwable t) {
                // Handle failure
                Toast.makeText(getActivity(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
