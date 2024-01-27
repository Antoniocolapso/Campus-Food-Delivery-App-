package com.example.hasofoodapp.models;

public class HomeHorModel {
    private String image; // Keep the field name as imageUrl
    private String name;
    private int id; // Assuming this is the restaurant ID in your code



    public HomeHorModel(String image, String name, int id) {
        this.image = image;
        this.name = name;
        this.id = id;
    }

    public String getImageUrl() { // Getter method with the name imageUrl
        return image;
    }

    public void setImageUrl(String imageUrl) { // Setter method with the name imageUrl
        this.image = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurantId() { // Getter method with the name restaurantId
        return id;
    }

    public void setRestaurantId(int restaurantId) { // Setter method with the name restaurantId
        this.id = restaurantId;
    }
}
