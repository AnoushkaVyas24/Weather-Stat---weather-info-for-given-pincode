package com.Anoushka.Weather_info_for_pincode.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class WeatherRequestDTO {

    @NotBlank(message = "Pincode is required")
    private String pincode;

    @NotNull(message = "Date is required")
    private LocalDate forDate;

    // Constructors
    public WeatherRequestDTO() {}

    public WeatherRequestDTO(String pincode, LocalDate forDate) {
        this.pincode = pincode;
        this.forDate = forDate;
    }

    // Getters & Setters
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public LocalDate getForDate() { return forDate; }
    public void setForDate(LocalDate forDate) { this.forDate = forDate; }
}