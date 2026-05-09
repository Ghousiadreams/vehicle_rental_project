package model;

import java.time.LocalDateTime;

public class Vehicle {

    private int vehicleId;
    private String name;
    private String type;
    private String brand;
    private double pricePerDay;
    private boolean available;
    private String imageUrl;
    private LocalDateTime createdAt;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String name, String type, String brand,
                   double pricePerDay, boolean available,
                   String imageUrl, LocalDateTime createdAt) {

        this.vehicleId = vehicleId;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.available = available;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", name=" + name + ", type=" + type
                + ", brand=" + brand + ", pricePerDay=" + pricePerDay
                + ", available=" + available + "]";
    }
}