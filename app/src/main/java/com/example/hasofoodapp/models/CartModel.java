package com.example.hasofoodapp.models;

public class CartModel {

    int image;
    String name;
    String price;
    String rating;

    public CartModel(int image, String name, String price, String rating) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
