package com.example.hasofoodapp.models;

public class CartModel {

    int image;
    String name;
    int price;
    int quantity;
    String rating;

    public CartModel(int image, String name, int price, String rating, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public void incrementQuantity() {
        quantity++;
    }
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }


    }
}
