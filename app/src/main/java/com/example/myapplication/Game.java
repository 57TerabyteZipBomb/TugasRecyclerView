package com.example.myapplication;

import java.util.List;

public class Game {
    private String name;
    private String publisher;
    private String price;
    private int imageId;
    private String description;
    private String steamURL;

    public Game (String name, String publisher, String price, int imageId, String steamURL, String description){
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.imageId = imageId;
        this.description = description;
        this.steamURL = steamURL;
    }

    public Game (String name, String publisher, String price){
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getSteamURL() {
        return steamURL;
    }
}
