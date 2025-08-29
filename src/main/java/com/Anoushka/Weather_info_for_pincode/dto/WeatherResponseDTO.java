package com.Anoushka.Weather_info_for_pincode.dto;

import java.time.LocalDate;

public class WeatherResponseDTO {

    private String pincode;
    private LocalDate date;
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;

    // Constructors
    public WeatherResponseDTO() {}

    public WeatherResponseDTO(String pincode, LocalDate date, double temperature,
                              String description, int humidity, double windSpeed) {
        this.pincode = pincode;
        this.date = date;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    // Getters & Setters
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }
}
