package com.example.hasofoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.models.AddToCartRequest;
import com.example.hasofoodapp.models.CartModel;
import com.example.hasofoodapp.network.ApiService;
import com.example.hasofoodapp.network.RetrofitClient;
import com.example.hasofoodapp.ui.MyCartFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {

    List<CartModel> list;
    MyCartFragment myCartFragment; // Add a reference to MyCartFragment


    public CartAdapter(List<CartModel> list, MyCartFragment myCartFragment) {
        this.list = list;
        this.myCartFragment = myCartFragment;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        // Retrieve data for the current position
        CartModel currentItem = list.get(position);

        // Now you can use 'currentItem' to set values in your ViewHolder views
        Picasso.get().load(currentItem.getImage()).into(holder.imageView);
        holder.name.setText(currentItem.getName());
        holder.price.setText(String.valueOf(currentItem.getPrice()));
        holder.rating.setText(String.valueOf(currentItem.getRating()));
        holder.quantity.setText(String.valueOf(currentItem.getQuantity()));

        // Set click listeners for buttons using 'position'
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.incrementQuantity();

                notifyItemChanged(position);
                myCartFragment.updateTotal();
                ApiService apiService = RetrofitClient.getApiService().create(ApiService.class);
                AddToCartRequest request = new AddToCartRequest(2, currentItem.getId(), currentItem.getQuantity());
                Call<Void> addToCartCall = apiService.addToCart(request);
                addToCartCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        //
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Handle failure if needed

                    }
                });
            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.decrementQuantity();

                notifyItemChanged(position);
                myCartFragment.updateTotal();
                ApiService apiService = RetrofitClient.getApiService().create(ApiService.class);
                AddToCartRequest request = new AddToCartRequest(2, currentItem.getId(), currentItem.getQuantity());
                Call<Void> addToCartCall = apiService.addToCart(request);
                addToCartCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        //
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Handle failure if needed

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView, minusButton, plusButton;
        TextView name, rating, price, quantity;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            price = itemView.findViewById(R.id.textView12);
            quantity = itemView.findViewById(R.id.quantity);
            minusButton = itemView.findViewById(R.id.minus_button);
            plusButton = itemView.findViewById(R.id.plus_button);

            // Add null checks
            if (plusButton != null) {
                plusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle plus button click
                        if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                            CartModel currentItem = list.get(getAdapterPosition());
                            currentItem.incrementQuantity();
                            notifyItemChanged(getAdapterPosition());
                            myCartFragment.updateTotal();
                        }
                    }
                });
            }

            if (minusButton != null) {
                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle minus button click
                        if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                            CartModel currentItem = list.get(getAdapterPosition());
                            currentItem.decrementQuantity();
                            notifyItemChanged(getAdapterPosition());
                            myCartFragment.updateTotal();
                        }
                    }
                });
            }
        }
    }

}
