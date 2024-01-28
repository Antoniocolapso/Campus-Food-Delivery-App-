package com.example.hasofoodapp.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.models.OrderModel;

import java.util.List;

// OrderAdapter.java
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<OrderModel> orderList;

    public OrderAdapter(List<OrderModel> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel order = orderList.get(position);
        // Set order details to ViewHolder views
        holder.textViewOrderId.setText("Order ID: " + order.getOrderId());
        holder.textViewCustomerAddress.setText("Address: " + order.getAddress());
        // ... Set other order details
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewOrderId, textViewCustomerAddress, textViewStatus, textViewPaymentStatus;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewOrderId = itemView.findViewById(R.id.textViewOrderId);
            textViewCustomerAddress = itemView.findViewById(R.id.textViewCustomerAddress);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewPaymentStatus = itemView.findViewById(R.id.textViewPaymentStatus);
            // ... Initialize other views
        }
    }
}
