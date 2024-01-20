package com.example.hasofoodapp.models;

public class DetailedDailyModel {
    int image;
    String name;
    String  description;
    String  price;
    String  rating;
    String   timing;

    public DetailedDailyModel(int image, String name, String description, String price, String rating, String timing) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.timing = timing;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
