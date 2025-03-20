package com.example.TripPrice;

public class TripPrice {

    public double calculatePrice(double fuelConsuption, double distance, double fuelPrice) {
        return fuelConsuption * (distance / 100) * fuelPrice;
    }

    public double calculatePriceWithReturn(double fuelConsuption, double distance, double fuelPrice) {
        return (fuelConsuption * (distance / 100) * fuelPrice) * 2;
    }

}
