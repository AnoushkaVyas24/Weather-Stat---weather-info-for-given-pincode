package com.Anoushka.Weather_info_for_pincode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "location_info")
public class LocationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pincode;   // e.g., "411014"

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    // Constructors
    public LocationInfo() {}

    public LocationInfo(String pincode, double latitude, double longitude) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}