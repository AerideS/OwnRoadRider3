package com.example.ownroadrider;

public class City {
    private String name;
    private double latitude;
    private double longitude;
    private String theme;

    public City(String name, double latitude, double longitude, String theme) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.theme = theme;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTheme() {
        return theme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
