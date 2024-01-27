package com.example.hasofoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.models.HomeHorModel;
import com.example.hasofoodapp.ui.home.HomeFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    public interface RestaurantClickListener {
        void onRestaurantClick(int restaurantId);
    }

    private ArrayList<HomeHorModel> list;
    private RestaurantClickListener restaurantClickListener;

    public HomeHorAdapter(HomeFragment homeFragment, FragmentActivity activity, ArrayList<HomeHorModel> list) {
        this.list = list;
        this.restaurantClickListener = homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeHorModel currentItem = list.get(position);

        // Assuming HomeHorModel has an 'imageUrl' property
        // Load image from URL using Picasso
        Picasso.get().load(currentItem.getImageUrl()).into(holder.imageView);

        holder.name.setText(currentItem.getName());

        // Handle item click if needed
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify the listener with the restaurant ID when an item is clicked
                if (restaurantClickListener != null) {
                    restaurantClickListener.onRestaurantClick(currentItem.getRestaurantId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_txt);
        }
    }
}
