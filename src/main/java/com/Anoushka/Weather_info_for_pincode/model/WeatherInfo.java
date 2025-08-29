package com.Anoushka.Weather_info_for_pincode.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather_info")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationInfo location;   // Foreign key reference to pincode & lat/long

    @Column(nullable = false)
    private LocalDate date;          // Weather info date

    @Column(nullable = false)
    private double temperature;      // Example: in Celsius

    @Column(nullable = false)
    private String description;      // Example: "clear sky"

    @Column(nullable = false)
    private int humidity;            // %

    @Column(nullable = false)
    private double windSpeed;        // m/s

    // Constructors
    public WeatherInfo() {}

    public WeatherInfo(LocationInfo location, LocalDate date, double temperature,
                       String description, int humidity, double windSpeed) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public LocationInfo getLocation() { return location; }
    public void setLocation(LocationInfo location) { this.location = location; }

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