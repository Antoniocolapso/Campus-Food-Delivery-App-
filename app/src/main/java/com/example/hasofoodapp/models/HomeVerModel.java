package com.example.hasofoodapp.models;

public class HomeVerModel {

    private int id;
    private String image; // Change the field name to imageUrl
    private String name;
    private String rating;
    private String description;
    private int cost;

    public HomeVerModel(String image, String name, String rating, String description, int cost, int id) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.cost = cost;
        this.id = id;
    }

    public int getItemId() {
        return id;
    }

    public void SetItemID(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() { // Getter method with the name imageUrl
        return image;
    }
    public int getPrice() {
        return cost; // Assuming your code's "price" is equivalent to API's "cost"
    }

    // Setter method for API's "cost"
    public void setPrice(int cost) {
        this.cost = cost; // Assuming your code's "price" is equivalent to API's "cost"
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



}
