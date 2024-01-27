package com.example.hasofoodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.models.AddToCartRequest;
import com.example.hasofoodapp.models.HomeVerModel;
import com.example.hasofoodapp.network.ApiService;
import com.example.hasofoodapp.network.RetrofitClient;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    List<HomeVerModel> list;

    public HomeVerAdapter(Context context, List<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HomeVerModel currentItem = list.get(position);

        // Load image from URL using Picasso
        Picasso.get().load(currentItem.getImageUrl()).into(holder.imageView);

        holder.name.setText(currentItem.getName());
        holder.rating.setText(currentItem.getRating());

        // Convert int price to String before setting it
        holder.price.setText(String.valueOf(currentItem.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);

                View sheetView = LayoutInflater.from(context).inflate(R.layout.botoom_sheet_layout, null);
                Button addToCartBtn = sheetView.findViewById(R.id.add_to_cart);
                addToCartBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the "Add to Cart" click event here
                        addToCart(currentItem.getItemId()); // Pass the item ID to the addToCart method
                        Toast.makeText(context, "Item added to cart.\nYou Can Change Quantity in My Cart.", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_price);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);
                TextView bottomDescription = sheetView.findViewById(R.id.detailed_des);

                bottomName.setText(currentItem.getName());
                bottomPrice.setText(String.valueOf(currentItem.getPrice()));  // Convert int price to String
                bottomRating.setText(currentItem.getRating());
                bottomDescription.setText(currentItem.getDescription());
                // Load image from URL using Picasso
                Picasso.get().load(currentItem.getImageUrl()).into(bottomImg);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });
    }


    // Add this method to handle "Add to Cart" functionality
    private void addToCart(int itemId) {
        // Implement the logic to add the item to the cart using the item ID
        // You can make a network request or update a local database, depending on your backend setup

        // For example, you can show a toast message indicating the item was added to the cart
        Toast.makeText(context, "Item added to cart. You can change quantity in My Cart.", Toast.LENGTH_SHORT).show();

        // Make a network request to add the item to the cart
// Create an instance of your ApiService using RetrofitClient
        ApiService apiService = RetrofitClient.getApiService().create(ApiService.class);

// Create an instance of AddToCartRequest
        AddToCartRequest request = new AddToCartRequest(2, itemId, 1); // Assuming 2 as the userID and 1 as the quantity

// Make the API call to add the item to the cart
        Call<Void> addToCartCall = apiService.addToCart(request);
        addToCartCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Item added to cart successfully!");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle failure if needed
                showToast("Failed to add item to cart. Please try again.");
            }
        });
    }

    // Helper method to show Toast messages
    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, rating, price, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);
            //description = itemView.findViewById(R.id.detailed_des);
        }
    }
}
