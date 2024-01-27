package com.example.hasofoodapp.models;

import java.util.List;

public class CartResponse {
    private List<CartModel> items;
    private int totalAmount;

    public List<CartModel> getItems() {
        return items;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
