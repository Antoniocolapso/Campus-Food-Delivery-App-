package com.example.hasofoodapp.models;

public class AddToCartRequest {
    private int userID;
    private int item_id;
    private int quantity;

    public AddToCartRequest(int userID, int item_id, int quantity) {
        this.userID = userID;
        this.item_id = item_id;
        this.quantity = quantity;
    }
}