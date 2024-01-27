package com.example.hasofoodapp.models;

public class CartModel {




    int id;
    String image;
    String name;
    int amount;
    int quantity;
    Double rating;

    public CartModel(int id, String image, String name, int amount, Double rating, int quantity) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.amount = amount;
        this.rating = rating;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return amount;
    }



    public Double getRating() {
        return rating;
    }


    public void incrementQuantity() {
        quantity++;
    }
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
